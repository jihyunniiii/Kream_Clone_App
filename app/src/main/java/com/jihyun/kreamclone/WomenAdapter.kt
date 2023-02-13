package com.jihyun.kreamclone

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.kreamclone.databinding.ItemShortcutBinding

const val type_shortcut = 1
const val type_title = 2
const val type_product = 3

class WomenAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var womenList: List<womenItem> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return womenList[position].itemType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            type_shortcut -> {
                val binding = ItemShortcutBinding.inflate(inflater, parent, false)
                shortcutViewHolder(binding)
            }
            else -> {
                // product item 생성 후 수정 필요
                val binding = ItemShortcutBinding.inflate(inflater, parent, false)
                shortcutViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (womenList[position].itemType) {
            type_shortcut -> {
                (holder as shortcutViewHolder).onBind(womenList[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    override fun getItemCount(): Int = womenList.size

    fun setWomenList(womenList: List<womenItem>) {
        this.womenList = womenList.toList()
        notifyDataSetChanged()
    }

    class shortcutViewHolder(
        private val binding: ItemShortcutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: womenItem) {
            binding.civItemShortcutImage.setImageDrawable(binding.root.context.getDrawable(data.image!!))
            binding.tvItemShortcutTitle.text = data.title
        }
    }
}