package com.mohammadhashem.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.mohammadhashem.home.adapter.onclick.OnClickAdapter
import com.mohammadhashem.home.adapter.viewholder.CurrenciesViewHolder
import com.mohammadhashem.home.databinding.ItemCurrencyBinding
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.utils.imageloader.GlideImageLoader


class CurrenciesAdapter : PagingDataAdapter<CryptoModel, CurrenciesViewHolder>(CurrenciesComparator) {
        private lateinit var clickListener: OnClickAdapter
        lateinit var imageLoader: GlideImageLoader


    override fun onBindViewHolder(holder: CurrenciesViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it,imageLoader,position) }
    }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesViewHolder {
            val inflater =
                ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CurrenciesViewHolder(inflater, parent.context, clickListener)
        }



        fun updateData(onClick:OnClickAdapter,imageLoader: GlideImageLoader) {
            this.clickListener = onClick
            this.imageLoader = imageLoader
        }


        object CurrenciesComparator : DiffUtil.ItemCallback<CryptoModel>() {
            override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel) =
                oldItem == newItem
        }


}