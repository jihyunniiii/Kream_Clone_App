package com.jihyun.kreamclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.kreamclone.databinding.ItemBrandProductBinding
import com.jihyun.kreamclone.databinding.ItemGeneralProductBinding
import java.text.DecimalFormat

const val option_exist = 7
const val option_no_exist = 8
const val product_type_general = 9
const val product_type_brand = 10

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
                val binding = ItemBrandProductBinding.inflate(inflater, parent, false)
                brandProductViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (productList[position].productType) {
            product_type_general -> {
                (holder as generalProductViewHolder).onBind(productList[position])
                holder.setIsRecyclable(false)
            }
            product_type_brand -> {
                (holder as brandProductViewHolder).onBind(productList[position])
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

    inner class brandProductViewHolder(
        private val binding: ItemBrandProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ProductItem) {
            binding.ivItemBrandProductImage.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvItemBrandProductBrand.text = data.brand
            binding.tvItemBrandProductName.text = data.name
            binding.tvItemBrandProductPrice.text =
                if (data.option == option_exist) {
                    salePrice(data.price, data.sale!!)
                } else {
                    data.price
                }
            binding.tvItemBrandDiscount.visibility =
                if (data.option == option_exist) {
                    binding.tvItemBrandDiscount.text = data.sale!!
                    View.VISIBLE
                } else {
                    View.GONE
                }
        }
    }

    fun salePrice(price: String, sale: String): String {
        var priceNumber = price.replace("[^\\d]".toRegex(), "")
        var priceNum = priceNumber.toInt()
        var saleNumber = sale.replace("[^\\d]".toRegex(), "")
        var saleNum = saleNumber.toInt()

        priceNum = (priceNum * (100 - saleNum) * 0.01).toInt()

        val format = DecimalFormat("#,###")

        return (format.format(priceNum) + "원")
    }
}