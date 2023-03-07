package com.jihyun.kreamclone

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.kreamclone.databinding.ItemReleaseProductBinding

const val to_be_released = 12
const val end_of_release = 13

class ReleaseItemAdapter(context: Context) :
    RecyclerView.Adapter<ReleaseItemAdapter.ReleaseItemViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var releaseItemList: List<ReleaseItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReleaseItemViewHolder {
        val binding = ItemReleaseProductBinding.inflate(inflater, parent, false)
        return ReleaseItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReleaseItemViewHolder, position: Int) {
        holder.onBind(releaseItemList[position])
    }

    override fun getItemCount(): Int = releaseItemList.size

    fun setReleaseItemList(releaseItemList: List<ReleaseItem>) {
        this.releaseItemList = releaseItemList.toList()
        notifyDataSetChanged()
    }

    class ReleaseItemViewHolder(
        private val binding: ItemReleaseProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ReleaseItem) {
            binding.ivItemReleaseProductImage.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvItemReleaseProductBrand.text = data.brand
            binding.tvItemReleaseProductName.text = data.name

            if (data.option == end_of_release) {
                binding.ivItemReleaseProductImage.alpha = 0.3F
            }
        }
    }
}