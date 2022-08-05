package com.mohammadhashem.home.bottomsheet

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mohammadhashem.home.databinding.BottomSheetFilterBinding
import com.mohammadhashem.usecase.model.InputData
import com.mohammadhashem.utils.constval.PAGE_SIZE


class BottomSheetFilter : BottomSheetDialogFragment() {

    lateinit var inputData: InputData
    lateinit var onClickBottomSheet: OnClickBottomSheet

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = BottomSheetFilterBinding.inflate(layoutInflater, container, false)
        binding.root.minimumHeight =
            Resources.getSystem().displayMetrics.heightPixels % 80
        binding.ivCloseBottomsheet.setOnClickListener {
            dialog?.let {
                dismiss()
            }
        }
        binding.clDoFilter.setOnClickListener {
            try {
                val newInput = InputData(1, PAGE_SIZE,binding.spSort.selectedItem.toString(),binding.spSortType.selectedItem.toString(),
                    (binding.etFromVolume.text.toString()).toDouble(),(binding.etToVolume.text.toString()).toDouble(),
                    (binding.etFrom.text.toString()).toDouble(),(binding.etTo.text.toString()).toDouble())
                onClickBottomSheet.onClickBottomSheet(newInput)
                dialog?.let {
                    dismiss()
                }
            }catch (e:Exception){
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
            }
        }
////////////////////SET VALUES
        val posSort = when(inputData.sort){
            "market_cap" -> 0
            "price" ->1
            "name" ->2
            "circulating_supply" ->3
            else ->0
        }
        binding.spSort.setSelection(posSort)
        if (inputData.sort_type=="desc"){
            binding.spSortType.setSelection(1)
        }
        binding.etFromVolume.setText(inputData.volume24_min.toString())
        binding.etToVolume.setText(inputData.volume24_max.toString())
        binding.etFrom.setText(inputData.percent_change24_min.toString())
        binding.etTo.setText(inputData.percent_change24_max.toString())
///////////////////////////////
        return binding.root
    }

    fun setData(inputData: InputData,onClickBottomSheet: OnClickBottomSheet){
        this.inputData = inputData
        this.onClickBottomSheet = onClickBottomSheet
    }

    companion object {
        const val FilterTAG = "FILTER"
    }
}