package com.jihyun.kreamclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.kreamclone.databinding.ItemLineBinding
import com.jihyun.kreamclone.databinding.ItemProductBinding
import com.jihyun.kreamclone.databinding.ItemShortcutBinding
import com.jihyun.kreamclone.databinding.ItemTitleBinding

const val type_shortcut = 1
const val type_title = 2
const val type_product = 3
const val type_line = 4
const val type_quick_delivery = 5
const val type_no_quick_delivery = 6

class HomeAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var itemList: List<HomeItem> = emptyList()

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
            type_product -> {
                val binding = ItemProductBinding.inflate(inflater, parent, false)
                productViewHolder(binding)
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
            type_product -> {
                (holder as productViewHolder).onBind(itemList[position])
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

    class shortcutViewHolder(
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

    class titleViewHolder(
        private val binding: ItemTitleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {
            binding.tvItemTitleTitle.text = data.title[0]
            binding.tvItemTitleSubTitle.text = data.subTitle[0]
        }
    }

    class productViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {
            binding.ivItemProductImage1.setImageDrawable(binding.root.context.getDrawable(data.image[0]!!))
            binding.tvItemProductBrand1.text = data.subTitle[0]
            binding.tvItemProductTitle1.text = data.title[0]
            binding.tvItemProductPrice1.text = data.price[0]
            binding.layoutQuickDelivery1.visibility =
                if (data.quickDelivery[0] == type_quick_delivery) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            binding.ivItemProductImage2.setImageDrawable(binding.root.context.getDrawable(data.image[1]!!))
            binding.tvItemProductBrand2.text = data.subTitle[1]
            binding.tvItemProductTitle2.text = data.title[1]
            binding.tvItemProductPrice2.text = data.price[1]
            binding.layoutQuickDelivery2.visibility =
                if (data.quickDelivery[1] == type_quick_delivery) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
        }
    }

    class lineViewHolder(
        private val binding: ItemLineBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {

        }
    }
}