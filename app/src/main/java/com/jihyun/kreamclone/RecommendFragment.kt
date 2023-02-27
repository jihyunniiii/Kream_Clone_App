package com.jihyun.kreamclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jihyun.kreamclone.databinding.FragmentRecommendBinding

class RecommendFragment : Fragment() {
    private var _binding: FragmentRecommendBinding? = null
    private val binding: FragmentRecommendBinding
        get() = requireNotNull(_binding)

    private var recommendList = listOf(
        HomeItem(
            type_banner,
            listOf(
                R.drawable.recommend_banner_image1,
                R.drawable.recommend_banner_image2,
                R.drawable.recommend_banner_image3,
                R.drawable.recommend_banner_image4,
                R.drawable.recommend_banner_image5,
                R.drawable.recommend_banner_image6,
                R.drawable.recommend_banner_image7
            ),
            listOf(null),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.recommend_shortcut_image1,
                R.drawable.recommend_shortcut_image2,
                R.drawable.recommend_shortcut_image3,
                R.drawable.recommend_shortcut_image4,
                R.drawable.recommend_shortcut_image5
            ),
            listOf("퀴즈 오픈 예정", "남성 추천", "여성 추천", "웰컴드로우", "인기 브랜드"),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.recommend_shortcut_image6,
                R.drawable.recommend_shortcut_image7,
                R.drawable.recommend_shortcut_image8,
                R.drawable.recommend_shortcut_image9,
                R.drawable.recommend_shortcut_image10
            ),
            listOf("정가 아래", "인기 럭셔리", "Spring", "셀럽픽", "봄 데일리룩"),
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
            listOf("Just Dropped"),
            "발매 상품",
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
                    product_type_general,
                    R.drawable.recommend_just_dropped_product1,
                    "Stussy",
                    "Stussy x Levi's Embossed Trucker Jacket Indigo",
                    "690,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.recommend_just_dropped_product2,
                    "Darkr8m Studio",
                    "Darkr8m Studio x Tanaka Flowering Cap Black",
                    "118,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.recommend_just_dropped_product3,
                    "Music & Goods",
                    "McDonald's x BT21 Figurine Set Collectors Kit",
                    "99,000원",
                    null,
                    option_exist
                ),
                ProductItem(
                    product_type_brand,
                    R.drawable.recommend_just_dropped_product4,
                    "Keen",
                    "[KREAM Exclusive] KEEN x NAC Jasper Rocks SP Sneakers Dark Gray",
                    "179,000원",
                    "5%",
                    option_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.recommend_just_dropped_product5,
                    "Nike",
                    "Nike Dunk Low Retro PRM Year of The Rabbit",
                    "161,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.recommend_just_dropped_product6,
                    "IAB Studio",
                    "IAB Studio Half Zip-Up Black White",
                    "180,000원",
                    null,
                    option_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.recommend_just_dropped_product7,
                    "Nike",
                    "(W) Nike Dunk Low Essential Game Royal",
                    "134,000원",
                    null,
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.recommend_just_dropped_product8,
                    "New Balance",
                    "New Balance x JJJJound 991 Made in UK Grey",
                    "687,000원",
                    null,
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
                R.drawable.recommend_brand_focus_image1,
                R.drawable.recommend_brand_focus_image2,
                R.drawable.recommend_brand_focus_image3,
                R.drawable.recommend_brand_focus_image4,
                R.drawable.recommend_brand_focus_image5
            ),
            listOf("발렌시아가", "샤넬", "애플", "스톤 아일랜드", "아미"),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.recommend_brand_focus_image6,
                R.drawable.recommend_brand_focus_image7,
                R.drawable.recommend_brand_focus_image8,
                R.drawable.recommend_brand_focus_image9,
                R.drawable.recommend_brand_focus_image10
            ),
            listOf("메종키츠네", "폴로", "헬리녹스", "루이비통", "롤렉스"),
            null,
            listOf(null),
            null
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.recommend_brand_focus_image11,
                R.drawable.recommend_brand_focus_image12,
                R.drawable.recommend_brand_focus_image13,
                R.drawable.recommend_brand_focus_image14,
                R.drawable.recommend_brand_focus_image15
            ),
            listOf("로로 피아나", "우영미", "고야드", "겐조", "오니츠카 타이거"),
            null,
            listOf(null),
            null
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recommendAdapter = HomeItemAdapter(requireContext())
        binding.rvRecommend.adapter = recommendAdapter
        recommendAdapter.setItemList(recommendList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}