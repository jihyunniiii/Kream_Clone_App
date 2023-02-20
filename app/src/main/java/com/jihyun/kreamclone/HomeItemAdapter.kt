package com.jihyun.kreamclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.kreamclone.databinding.ItemLineBinding
import com.jihyun.kreamclone.databinding.ItemProductListBinding
import com.jihyun.kreamclone.databinding.ItemShortcutBinding
import com.jihyun.kreamclone.databinding.ItemTitleBinding

const val type_shortcut = 1
const val type_title = 2
const val type_product_list = 3
const val type_line = 4
const val detail_exist = 5
const val detail_no_exist = 6

class HomeItemAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var itemList: List<HomeItem> = emptyList()
    private val context = context

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
            binding.tvItemTitleDetails.visibility =
                if (data.detail == detail_exist) {
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

    inner class lineViewHolder(
        private val binding: ItemLineBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeItem) {

        }
    }
}