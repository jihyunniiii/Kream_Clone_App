package com.jihyun.kreamclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jihyun.kreamclone.databinding.FragmentWomenBinding

class WomenFragment : Fragment() {
    private var _binding: FragmentWomenBinding? = null
    private val binding: FragmentWomenBinding
        get() = requireNotNull(_binding)

    private var womenList = listOf(
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.women_new,
                R.drawable.women_luxury,
                R.drawable.women_popular_shoes,
                R.drawable.women_celeb_pick,
                R.drawable.women_small_luxury
            ),
            listOf("New", "럭셔리", "인기 신발", "셀럽픽", "스몰 럭셔리"),
            null,
            listOf(null)
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            null,
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("For Women"),
            "여성 추천 상품",
            listOf(null)
        ),
        HomeItem(
            type_product_list,
            listOf(null),
            listOf(null),
            null,
            listOf(
                ProductItem(
                    product_type_general,
                    R.drawable.women_for_women_product1,
                    "Nike",
                    "(W) Nike Classic Cortez Leather White Black",
                    "176,000원",
                    option_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.women_for_women_product2,
                    "Nike",
                    "Nike x Stussy Washed Fleece Pants Black (DO5296-010)",
                    "119,000원",
                    option_no_exist
                )
            )
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            null,
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("New Arrivals"),
            "신규 등록 여성 상품",
            listOf(null)
        ),
        HomeItem(
            type_product_list,
            listOf(null),
            listOf(null),
            null,
            listOf(
                ProductItem(
                    product_type_general,
                    R.drawable.women_new_arrivals_product1,
                    "Jordan",
                    "(W) Jordan 1 Zoom Air CMFT 2 Phantom University Blue",
                    "180,000원",
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.women_new_arrivals_product2,
                    "Nike",
                    "Nike x Stussy Air Penny II Fossil",
                    "255,000원",
                    option_no_exist
                )
            )
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            null,
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("Rising Sneakers"),
            "인기 상승 스니커즈",
            listOf(null)
        ),
        HomeItem(
            type_product_list,
            listOf(null),
            listOf(null),
            null,
            listOf(
                ProductItem(
                    product_type_general,
                    R.drawable.women_rising_sneakers_product1,
                    "Adidas",
                    "(W) Adidas Gazelle Bold Super Pop",
                    "280,000원",
                    option_no_exist
                ),
                ProductItem(
                    product_type_general,
                    R.drawable.women_rising_sneakers_product2,
                    "Nike",
                    "(GS) Nike Court Borough Low 2 Light Smoke Grey",
                    "60,000원",
                    option_exist
                )
            )
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            null,
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("Brand Focus"),
            "인기 여성 브랜드",
            listOf(null)
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.women_brand_focus_image1,
                R.drawable.women_brand_focus_image2,
                R.drawable.women_brand_focus_image3,
                R.drawable.women_brand_focus_image4,
                R.drawable.women_brand_focus_image5
            ),
            listOf("생로랑", "가니", "마르지엘라", "비비안\n웨스트우드", "디올"),
            null,
            listOf(null)
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.women_brand_focus_image6,
                R.drawable.women_brand_focus_image7,
                R.drawable.women_brand_focus_image8,
                R.drawable.women_brand_focus_image9,
                R.drawable.women_brand_focus_image10
            ),
            listOf("셀린느", "텔파", "프라다", "이자벨 마랑", "다이슨"),
            null,
            listOf(null)
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWomenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val womenAdapter = HomeItemAdapter(requireContext())
        binding.rvWomen.adapter = womenAdapter
        womenAdapter.setItemList(womenList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}