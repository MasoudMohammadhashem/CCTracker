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
import com.mohammadhashem.baseui.base.BaseFragment
import com.mohammadhashem.home.adapter.CurrenciesAdapter
import com.mohammadhashem.home.adapter.listener.OnClickAdapterHandler
import com.mohammadhashem.home.bottomsheet.BottomSheetFilter
import com.mohammadhashem.home.bottomsheet.OnClickBottomSheet
import com.mohammadhashem.home.databinding.FragmentHomeBinding
import com.mohammadhashem.home.fragment.viewmodel.HomeViewModel
import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.model.InputData
import com.mohammadhashem.utils.imageloader.GlideImageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentHome : BaseFragment<FragmentHomeBinding>(), OnClickBottomSheet,
    OnClickAdapterHandler {
    override fun setBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    @Inject
    lateinit var imageLoader: GlideImageLoader
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var progressBar: ProgressBar
    private lateinit var rvCurrencies: RecyclerView
    private lateinit var adapter: CurrenciesAdapter
    private var inputData = com.mohammadhashem.domain.model.InputData(
        1, 10, "volume_24h", "asc", 0.0,
        1.0, -100.0, 100000.0
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        clickListeners()
        initAdapter()
        fetchCacheData()
    }

    private fun fetchRemoteData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                try {
                    viewModel.fetchData(inputData).collect{
                        adapter.submitData(it)
                    }
                }catch (e:Exception){
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun fetchCacheData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                try {
                    viewModel.fetchData().collect {
                        adapter.submitData(it)
                    }
                }catch (e:Exception){
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
                    fetchRemoteData()
                }
            }
        }
    }


    private fun initAdapter() {
        adapter = CurrenciesAdapter()
        binding.rvCryptoCurrencies.adapter = adapter
        adapter.updateData(this, imageLoader)
    }

    private fun clickListeners() {
        binding.fbFilter.setOnClickListener {
            val btsh = BottomSheetFilter()
            btsh.setData(inputData, this)
            btsh.show(parentFragmentManager, BottomSheetFilter.FilterTAG)
        }
    }

    private fun initView() {
        progressBar = binding.listProgressBar
        rvCurrencies = binding.rvCryptoCurrencies
        binding.rvCryptoCurrencies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


    }


    override fun onClickBottomSheet(input: com.mohammadhashem.domain.model.InputData) {
        this.inputData = input
        lifecycleScope.launch {
            fetchRemoteData()
        }
    }

    override fun onClick(model: com.mohammadhashem.domain.model.CryptoModel) {
        Toast.makeText(requireContext(), "id: ${model.id}  name: ${model.name}", Toast.LENGTH_SHORT)
            .show()
    }
}