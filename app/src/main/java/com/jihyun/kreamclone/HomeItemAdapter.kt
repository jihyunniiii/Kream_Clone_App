package com.jihyun.kreamclone

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.jihyun.kreamclone.databinding.*
import kotlinx.coroutines.Runnable
import java.lang.Math.ceil

const val type_shortcut = 1
const val type_title = 2
const val type_product_list = 3
const val type_banner = 4
const val type_line = 5
const val detail_exist = 6
const val detail_no_exist = 7

class HomeItemAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var itemList: List<HomeItem> = emptyList()
    private val context = context
    private var itemCount: Int = 0

    override fun getItemViewType(position: Int): Int {
        return itemList[position].itemType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            type_shortcut -> {
                val binding = ItemShortcutBinding.inflate(inflater, parent, false)
                shortcutViewHolder(binding)
            }
            type_title -> {
                val binding = ItemTitleBinding.inflate(inflater, parent, false)
                titleViewHolder(binding)
            }
            type_product_list -> {
                val binding = ItemProductListBinding.inflate(inflater, parent, false)
                productListViewHolder(binding)
            }
            type_banner -> {
                val binding = ItemBannerListBinding.inflate(inflater, parent, false)
                bannerListViewHolder(binding)
            }
            else -> {
                val binding = ItemLineBinding.inflate(inflater, parent, false)
                lineViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (itemList[position].itemType) {
            type_shortcut -> {
                (holder as shortcutViewHolder).onBind(itemList[position])
                holder.setIsRecyclable(false)
            }
            type_title -> {
                (holder as titleViewHolder).onBind(itemList[position])
                holder.setIsRecyclable(false)
            }
            type_product_list -> {
                (holder as productListViewHolder).onBind(itemList[position])
                holder.setIsRecyclable(false)
            }
            type_banner -> {
                (holder as bannerListViewHolder).onBind(itemList[position])
                itemCount = itemList[position].image.size
                holder.bannerBar()
                holder.setIsRecyclable(false)
            }
            type_line -> {
                (holder as lineViewHolder).onBind(itemList[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun setItemList(itemList: List<HomeItem>) {
        this.itemList = itemList.toList()
        notifyDataSetChanged()
    }

    inner class shortcutViewHolder(
        private val binding: ItemShortcutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {
            binding.civItemShortcutImage1.setImageDrawable(binding.root.context.getDrawable(data.image[0]!!))
            binding.tvItemShortcutTitle1.text = data.title[0]
            binding.civItemShortcutImage2.setImageDrawable(binding.root.context.getDrawable(data.image[1]!!))
            binding.tvItemShortcutTitle2.text = data.title[1]
            binding.civItemShortcutImage3.setImageDrawable(binding.root.context.getDrawable(data.image[2]!!))
            binding.tvItemShortcutTitle3.text = data.title[2]
            binding.civItemShortcutImage4.setImageDrawable(binding.root.context.getDrawable(data.image[3]!!))
            binding.tvItemShortcutTitle4.text = data.title[3]
            binding.civItemShortcutImage5.setImageDrawable(binding.root.context.getDrawable(data.image[4]!!))
            binding.tvItemShortcutTitle5.text = data.title[4]
        }
    }

    inner class titleViewHolder(
        private val binding: ItemTitleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {
            binding.tvItemTitleTitle.text = data.title[0]
            binding.tvItemTitleSubTitle.text = data.subTitle
            binding.tvItemTitleDetails.visibility = if (data.detail == detail_exist) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    inner class productListViewHolder(
        private val binding: ItemProductListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {
            val productItemAdapter = ProductItemAdapter(context)
            binding.rvProductList.adapter = productItemAdapter
            productItemAdapter.setProductList(data.product as List<ProductItem>)
        }
    }

    inner class bannerListViewHolder(
        private val binding: ItemBannerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var bannerPosition: Int = 0
        val handler = Handler(Looper.getMainLooper()) {
            binding.vpBanner.setCurrentItem(++bannerPosition, true)
            true
        }

        fun onBind(data: HomeItem) {
            val bannerAdapter = BannerViewPagerAdapter(context)
            binding.vpBanner.adapter = bannerAdapter
            bannerAdapter.setBannerList(data.image as List<Int>)

            bannerPosition = Int.MAX_VALUE / 2 - ceil(data.image.size.toDouble() / 2).toInt()
            binding.vpBanner.setCurrentItem(bannerPosition, false)

            val thread = Thread(PagerRunnable())
            thread.start()
        }

        inner class PagerRunnable : Runnable {
            override fun run() {
                while (true) {
                    Thread.sleep(7000)
                    handler.sendEmptyMessage(0)
                }
            }
        }

        fun bannerBar() {
            binding.vpBanner.apply {
                binding.viewBannerBarBackground.post {
                    var barWidth = binding.viewBannerBarBackground.measuredWidth / itemCount
                    var x = binding.viewBannerBarBackground.left

                    val lp = binding.viewBannerBar.layoutParams
                    lp?.let {
                        lp.width = barWidth
                        binding.viewBannerBar.layoutParams = lp
                    }

                    binding.viewBannerBar.translationX = x.toFloat()

                    this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                            val translatePosition = barWidth * (position % itemCount)
                            binding.viewBannerBar.translationX = (translatePosition + x).toFloat()
                        }
                    })
                }
            }
        }
    }

    inner class lineViewHolder(
        private val binding: ItemLineBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {

        }
    }
}