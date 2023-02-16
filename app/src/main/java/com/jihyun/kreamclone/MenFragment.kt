package com.jihyun.kreamclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jihyun.kreamclone.databinding.FragmentMenBinding

class MenFragment : Fragment() {
    private var _binding: FragmentMenBinding? = null
    private val binding: FragmentMenBinding
        get() = requireNotNull(_binding)

    private var menList = listOf(
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.men_new,
                R.drawable.men_luxury,
                R.drawable.men_popular_shoes,
                R.drawable.men_celeb_pick,
                R.drawable.men_sweat_setup
            ),
            listOf("New", "럭셔리", "인기 신발", "셀럽픽", "스웨트 셋업"),
            listOf(null),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("For Men"),
            listOf("남성 추천 상품"),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_product,
            listOf(
                R.drawable.men_for_men_product1,
                R.drawable.men_for_men_product2
            ),
            listOf(
                "Nike x Stussy Striped Wool Jacket Black (DR4023-010)",
                "Wooyoungmi iPhone Feather Case Black"
            ),
            listOf("Nike", "Wooyoungmi"),
            listOf("320,000원", "159,000원"),
            listOf(type_no_quick_delivery, type_no_quick_delivery)
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("New Arrivals"),
            listOf("신규 등록 남성 상품"),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_product,
            listOf(
                R.drawable.men_new_arrivals_product1,
                R.drawable.men_new_arrivals_product2
            ),
            listOf(
                "New Balance x JJJJound 991 Made in UK Grey",
                "Nike NSW Authentics Varsity Jacket Brown Basalt - Asia"
            ),
            listOf("New Balance", "Nike"),
            listOf("790,000원", "150,000원"),
            listOf(type_no_quick_delivery, type_no_quick_delivery)
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("Rising Sneakers"),
            listOf("인기 상승 스니커즈"),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_product,
            listOf(
                R.drawable.men_rising_sneakers_product1,
                R.drawable.men_rising_sneakers_product2
            ),
            listOf(
                "Jordan 1 High 85 Black White",
                "Nike x Stussy Air Penny II Rattan and Limestone"
            ),
            listOf("Jordan", "Nike"),
            listOf("358,000원", "263,000원"),
            listOf(type_no_quick_delivery, type_no_quick_delivery)
        ),
        HomeItem(
            type_line,
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_title,
            listOf(null),
            listOf("Brand Focus"),
            listOf("인기 남성 브랜드"),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.men_brand_focus_image1,
                R.drawable.men_brand_focus_image2,
                R.drawable.men_brand_focus_image3,
                R.drawable.men_brand_focus_image4,
                R.drawable.men_brand_focus_image5
            ),
            listOf("파타고니아", "소니", "바버", "보테가 베네타", "피어오브갓"),
            listOf(null),
            listOf(null),
            listOf(null)
        ),
        HomeItem(
            type_shortcut,
            listOf(
                R.drawable.men_brand_focus_image6,
                R.drawable.men_brand_focus_image7,
                R.drawable.men_brand_focus_image8,
                R.drawable.men_brand_focus_image9,
                R.drawable.men_brand_focus_image10
            ),
            listOf("아크테릭스", "우영미", "톰브라운", "C.P.컴퍼니", "야스히로"),
            listOf(null),
            listOf(null),
            listOf(null)
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menAdapter = HomeAdapter(requireContext())
        binding.rvMen.adapter = menAdapter
        menAdapter.setItemList(menList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}