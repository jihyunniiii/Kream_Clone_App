package com.jihyun.kreamclone

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.kreamclone.databinding.ItemBannerBinding

class BannerViewPagerAdapter(context: Context) :
    RecyclerView.Adapter<BannerViewPagerAdapter.bannerViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var bannerList: List<Int> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bannerViewHolder {
        val binding = ItemBannerBinding.inflate(inflater, parent, false)
        return bannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: bannerViewHolder, position: Int) {
        holder.onBind(bannerList[position % bannerList.size])
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    fun setBannerList(bannerList: List<Int>) {
        this.bannerList = bannerList.toList()
        notifyDataSetChanged()
    }

    inner class bannerViewHolder(
        private val binding: ItemBannerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Int) {
            binding.ivItemBannerImage.setImageDrawable(binding.root.context.getDrawable(data))
        }
    }
}