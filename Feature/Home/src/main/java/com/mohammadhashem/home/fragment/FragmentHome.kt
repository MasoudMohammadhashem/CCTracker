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
import com.mohammadhashem.home.databinding.FragmentHomeBinding
import com.mohammadhashem.home.fragment.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentHome : BaseFragment<FragmentHomeBinding>() {
    override fun setBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    private val viewModel: HomeViewModel by viewModels()
    lateinit var progressBar: ProgressBar
    lateinit var rvCurrencies:RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observables()

    }

    private fun initView() {
        progressBar = binding.listProgressBar
        rvCurrencies = binding.rvCryptoCurrencies
    }

    private fun observables() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.remoteStateFlow.collect(){
                    if (it.isNotEmpty()){
//                        val adapter = CurrenciesAdapter()
//                        binding.rvCryptoCurrencies.layoutManager =
//                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//                        binding.rvCryptoCurrencies.adapter = adapter
//                        adapter.setData(it,this,imageLoader)
                    }
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
}