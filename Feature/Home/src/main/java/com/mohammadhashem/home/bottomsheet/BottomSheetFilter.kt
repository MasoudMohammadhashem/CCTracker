package com.mohammadhashem.home.bottomsheet

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mohammadhashem.home.databinding.BottomSheetFilterBinding

class BottomSheetFilter : BottomSheetDialogFragment() {

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

//        val window: Window? = dialog!!.window
//        window?.setBackgroundDrawableResource(com.navaco.baseui.R.color.whiteTransparent)
        return binding.root
    }

    companion object {
        const val FilterTAG = "FILTER"
    }
}