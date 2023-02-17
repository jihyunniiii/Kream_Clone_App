package com.jihyun.kreamclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.kreamclone.databinding.ItemGeneralProductBinding

const val option_exist = 5
const val option_no_exist = 6
const val product_type_general = 7

class ProductItemAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var productList: List<ProductItem> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return productList[position].productType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            product_type_general -> {
                val binding = ItemGeneralProductBinding.inflate(inflater, parent, false)
                generalProductViewHolder(binding)
            }
            else -> {
                // brand product 만든 후 수정 필요
                val binding = ItemGeneralProductBinding.inflate(inflater, parent, false)
                generalProductViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (productList[position].productType) {
            product_type_general -> {
                (holder as generalProductViewHolder).onBind(productList[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    override fun getItemCount(): Int = productList.size

    fun setProductList(productList: List<ProductItem>) {
        this.productList = productList.toList()
        notifyDataSetChanged()
    }

    inner class generalProductViewHolder(
        private val binding: ItemGeneralProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ProductItem) {
            binding.ivItemProductImage.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvItemProductBrand.text = data.brand
            binding.tvItemProductName.text = data.name
            binding.tvItemProductPrice.text = data.price
            binding.layoutQuickDelivery.visibility =
                if (data.option == option_exist) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
        }
    }
}