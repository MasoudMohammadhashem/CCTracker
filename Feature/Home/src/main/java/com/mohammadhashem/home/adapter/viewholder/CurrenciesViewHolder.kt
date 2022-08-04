package com.mohammadhashem.home.adapter.viewholder

import android.content.Context
import com.mohammadhashem.baseui.BaseViewHolder
import com.mohammadhashem.home.adapter.onclick.OnClickAdapter
import com.mohammadhashem.home.databinding.ItemCurrencyBinding
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.utils.imageloader.GlideImageLoader

class CurrenciesViewHolder (
        override val binding: ItemCurrencyBinding,
        override val context: Context,
        private val onclick: OnClickAdapter
    ) :
        BaseViewHolder<CryptoModel>(binding, context) {
        override fun bind(task: CryptoModel, imageLoader: GlideImageLoader, position: Int) {

            imageLoader.loadImage(binding.ivCc,task.imageUrl)
            binding.tvName.text = task.name
            binding.tvMarketCap.text = task.market_cap
            binding.tvSymbol.text = task.symbol
            binding.tvPercentChange24.text = task.percent_change24

            binding.root.setOnClickListener {
                onclick.onClick(task)
            }
        }

    }
