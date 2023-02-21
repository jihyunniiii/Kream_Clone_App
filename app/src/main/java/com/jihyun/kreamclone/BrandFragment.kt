package com.jihyun.kreamclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jihyun.kreamclone.databinding.FragmentBrandBinding

class BrandFragment : Fragment() {
    private var _binding: FragmentBrandBinding? = null
    private val binding: FragmentBrandBinding
        get() = requireNotNull(_binding)

    private var brandList = listOf(
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.brand_all_brand,
                R.drawable.brand_sale_item,
                R.drawable.brand_men_recommend,
                R.drawable.brand_women_recommend,
                R.drawable.brand_tech_life
            ),
            listOf("모든 브랜드", "세일 아이템", "남성 추천", "여성 추천", "테크&라이프"),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("New Arrivals"),
            "신규 등록 상품",
            listOf(null),
            detail_no_exist
        ),
        HomeItem(
            type_product_list,
            listOf(null),
            listOf(null),
            null,
            listOf(
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product1,
                    "Cavish",
                    "Cavish Big Seller Logo Ball Cap Charcoal - 23SS",
                    "39,000원",
                    "15%",
                    option_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product2,
                    "Cavish",
                    "[KREAM Exclusive] Cavish Seller Logo S/S T-Shirt Navy - 23SS",
                    "39,000원",
                    "15%",
                    option_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product3,
                    "INSTANTFUNK",
                    "Instantfunk Women Crew Neck Croped Cable Knitted Sweater Blue",
                    "138,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product4,
                    "Polyteru",
                    "Polyteru Obscura Shell Jumper Black - 23SS",
                    "327,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product5,
                    "s/e/o",
                    "[KREAM Exclusive/Pre-Order] s/e/o Us Cap Pink",
                    "45,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product6,
                    "2000Archives",
                    "2000Archives Crop Matt Love Hoodie Black",
                    "78,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product7,
                    "Hunter",
                    "[KREAM Exclusive] Hunter Women Gardener Short Rainboots Dark Olive Clay",
                    "179,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_new_arrivals_product8,
                    "Scudo",
                    "[KREAM Exclusive] Scudo Color Stone Mix Ring",
                    "268,000원",
                    "10%",
                    option_exist
                )
            ),
            null
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBrandBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val brandAdapter = HomeItemAdapter(requireContext())
        binding.rvBrand.adapter = brandAdapter
        brandAdapter.setItemList(brandList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}