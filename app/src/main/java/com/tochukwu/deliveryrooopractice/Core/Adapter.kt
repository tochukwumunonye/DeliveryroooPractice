package com.tochukwu.deliveryrooopractice.Core

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tochukwu.deliveryrooopractice.R
import com.tochukwu.deliveryrooopractice.data.model.Applicable

import com.tochukwu.deliveryrooopractice.databinding.ItemArticleNewsBinding


class Adapter : androidx.recyclerview.widget.ListAdapter<Applicable, Adapter.ApplicableViewHolder>(
    Article_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicableViewHolder {
        val binding = ItemArticleNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ApplicableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApplicableViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    inner class ApplicableViewHolder(private val binding: ItemArticleNewsBinding) :RecyclerView.ViewHolder(binding.root) {

        fun bind(app: Applicable) {
            binding.apply {
                Glide.with(itemView).load(app.links.logo).into(logo)
                paymentName.text = app.label

            }

        }

    }
    companion object {
        private val Article_COMPARATOR = object : DiffUtil.ItemCallback<Applicable>() {
            override fun areItemsTheSame(oldItem: Applicable, newItem: Applicable) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Applicable, newItem: Applicable) =
                oldItem == newItem
        }

    }

}


