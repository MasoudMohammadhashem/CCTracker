package com.mohammadhashem.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mohammadhashem.home.adapter.listener.OnClickAdapterHandler
import com.mohammadhashem.home.databinding.ItemCurrencyBinding
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.utils.imageloader.GlideImageLoader

class CurrenciesViewHolder(
    private val binding: ItemCurrencyBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        task: CryptoModel,
        imageLoader: GlideImageLoader,
        onclick: OnClickAdapterHandler
    ) {
        imageLoader.loadImage(binding.ivCc, task.imageUrl)
        binding.tvName.text = task.name
        binding.tvMarketCap.text = task.market_cap
        binding.tvSymbol.text = task.symbol
        binding.tvPercentChange24.text = task.percent_change24
        binding.currencyItem.setOnClickListener {
            onclick.onClick(task)
        }

    }

}
