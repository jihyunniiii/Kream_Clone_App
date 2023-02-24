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
            type_banner,
            listOf(
                R.drawable.brand_banner_image1,
                R.drawable.brand_banner_image2,
                R.drawable.brand_banner_image3,
                R.drawable.brand_banner_image4,
                R.drawable.brand_banner_image5
            ),
            listOf(null),
            null,
            listOf(null),
            null
        ),
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
            listOf("Brand Focus"),
            "추천 브랜드",
            listOf(null),
            detail_no_exist
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.brand_brand_focus_image1,
                R.drawable.brand_brand_focus_image2,
                R.drawable.brand_brand_focus_image3,
                R.drawable.brand_brand_focus_image4,
                R.drawable.brand_brand_focus_image5
            ),
            listOf("폴리테루", "크래커", "소니", "킨", "사파리스팟"),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.brand_brand_focus_image6,
                R.drawable.brand_brand_focus_image7,
                R.drawable.brand_brand_focus_image8,
                R.drawable.brand_brand_focus_image9,
                R.drawable.brand_brand_focus_image10
            ),
            listOf("에스티유", "렉토", "써저리", "이미스", "더뮤지엄비어터"),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.brand_brand_focus_image11,
                R.drawable.brand_brand_focus_image12,
                R.drawable.brand_brand_focus_image13,
                R.drawable.brand_brand_focus_image14,
                R.drawable.brand_brand_focus_image15
            ),
            listOf("넘버링", "인스턴트펑크", "스쿠도", "미수아바흐브", "2000아카이브스"),
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
            listOf("Best Jackets Now"),
            "지금 인기 많은 재킷",
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
                    R.drawable.brand_best_jackets_now_product1,
                    "STU",
                    "[KREAM Exclusive] Stu Denim Jacket Black",
                    "279,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_jackets_now_product2,
                    "Surgery",
                    "Surgery Bone Cutting Varsity Jacket Ver.2 Black White",
                    "398,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.brand_best_jackets_now_product3,
                    "Ader Error",
                    "Ader Error x Converse Shapes Varsity Jacket Cobalt",
                    "417,000원",
                    null,
                    option_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_jackets_now_product4,
                    "KANGHYUK",
                    "Kanghyuk Hooded Bomber Jacket Black",
                    "490,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_jackets_now_product5,
                    "Recto",
                    "[KREAM Exclusive] Recto 70S Dog Tooth Check Wool Blazer Brown",
                    "528,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.brand_best_jackets_now_product6,
                    "Sansan Gear",
                    "Sansan Gear Zipper Jacket Black - 22FW",
                    "319,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_jackets_now_product7,
                    "STU",
                    "[KREAM Exclusive] Stu Embroidered Windbreaker Blue",
                    "289,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_jackets_now_product8,
                    "The Museum Visitor",
                    "The Museum Visitor Children Printed Fleece Ivory - 22FW",
                    "257,000원",
                    null,
                    option_no_exist
                )
            ),
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
            listOf("Best Sweats & Hoodie Now"),
            "지금 인기 많은 후드 & 스웨트셔츠",
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
                    R.drawable.brand_best_sweats_hoodie_now_product1,
                    "Cavish",
                    "Cavish Pictorial Zip Up Hoodie Ash - 23SS",
                    "99,000원",
                    "15%",
                    option_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_sweats_hoodie_now_product2,
                    "Safarispot",
                    "Safarispot Women 1/2 Basic Safari Hoodie Sky",
                    "92,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_sweats_hoodie_now_product3,
                    "s/e/o",
                    "[KREAM Exclusive/Pre-Order] s/e/o Women Logo Hoodie Heather Gray",
                    "128,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_sweats_hoodie_now_product4,
                    "Cavish",
                    "Cavish Seller Logo Hoodie Charcoal Pink - 23SS",
                    "79,000원",
                    "15%",
                    option_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_sweats_hoodie_now_product5,
                    "Surgery",
                    "Surgery Paisley Destroyed Hoodie Melange Beige",
                    "248,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.brand_best_sweats_hoodie_now_product6,
                    "Wooyoungmi",
                    "Wooyoungmi Feather Back Logo Hooded Sweatshirt Black - 23SS",
                    "463,000원",
                    null,
                    option_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.brand_best_sweats_hoodie_now_product7,
                    "Surgery",
                    "Surgery Typing Cutting Logo Hoodie Grey",
                    "148,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.brand_best_sweats_hoodie_now_product8,
                    "Essentials",
                    "Essentials The Core Collection Hoodie Light Oatmeal",
                    "169,000원",
                    null,
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