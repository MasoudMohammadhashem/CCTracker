package com.mohammadhashem.home.fragment

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammadhashem.baseui.BaseFragment
import com.mohammadhashem.home.adapter.CurrenciesAdapter
import com.mohammadhashem.home.adapter.onclick.OnClickAdapter
import com.mohammadhashem.home.bottomsheet.BottomSheetFilter
import com.mohammadhashem.home.databinding.FragmentHomeBinding
import com.mohammadhashem.home.fragment.viewmodel.HomeViewModel
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.InputData
import com.mohammadhashem.utils.constval.EXTRA_KEY_DATA
import com.mohammadhashem.utils.imageloader.GlideImageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FragmentHome : BaseFragment<FragmentHomeBinding>(),OnClickAdapter {
    override fun setBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    @Inject
    lateinit var imageLoader: GlideImageLoader
    private val viewModel: HomeViewModel by viewModels()
    lateinit var progressBar: ProgressBar
    lateinit var rvCurrencies:RecyclerView
    private val adapter = CurrenciesAdapter()
    private val inputData = InputData(1,10,"volume_24h", "asc", 0.0,
        1.0, -100.0, 100000.0)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observables()
        clickListeners()
        binding.rvCryptoCurrencies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvCryptoCurrencies.adapter = adapter
        adapter.updateData(this@FragmentHome,imageLoader)
    }

    private fun clickListeners() {
        binding.fbFilter.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(EXTRA_KEY_DATA, "BillsPhoneTAG")
            val payment = BottomSheetFilter()
            payment.arguments = bundle
            payment.show(parentFragmentManager, BottomSheetFilter.FilterTAG)
        }
    }

    private fun initView() {
        progressBar = binding.listProgressBar
        rvCurrencies = binding.rvCryptoCurrencies
        progressBar.visibility = View.GONE
        rvCurrencies.visibility = View.VISIBLE

    }

    private fun observables() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.fetchData(inputData).collect(){
                    adapter.submitData(it)
                }
            }
        }
        lifecycleScope.launch {
            viewModel.loading.collect {
                if (it){
                    progressBar.visibility = View.VISIBLE
                    rvCurrencies.visibility = View.GONE
                }else{
                    progressBar.visibility = View.GONE
                    rvCurrencies.visibility = View.VISIBLE
                }
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect() {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(model: CryptoModel) {
        Toast.makeText(requireContext(), "id: ${model.id}  name: ${model.name}", Toast.LENGTH_SHORT).show()
    }
}