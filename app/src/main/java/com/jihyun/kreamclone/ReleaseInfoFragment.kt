package com.jihyun.kreamclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.jihyun.kreamclone.databinding.FragmentReleaseInfoBinding

class ReleaseInfoFragment : Fragment() {
    private var _binding: FragmentReleaseInfoBinding? = null
    private val binding: FragmentReleaseInfoBinding
        get() = requireNotNull(_binding)

    private var releaseItemList = listOf(
        ReleaseItem(
            R.drawable.release_info_product1,
            "Nike",
            "Nike x Tiffany & Co. Air Force 1 Low SP Black Tiffany Blue",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product2,
            "Jordan",
            "Jordan 1 High 85 Black White",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product3,
            "Asics",
            "Asics x Kiko Kostadinov Gel-Quantum Zientzia Dark Grey",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product4,
            "Nike",
            "Nike Dunk Low Retro Grey Fog",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product5,
            "Nike",
            "Nike Dunk Low Retro Black",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product6,
            "New Balance",
            "New Balance 990v3 Made in USA Olive",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product7,
            "New Balance",
            "New Balance 990v1 Made in USA Olive",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product8,
            "New Balance",
            "New Balance 990v2 Made in USA Grey Tan",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product9,
            "Nike",
            "Nike Dunk High Retro Psychic Purple and Black",
            to_be_released
        ),
        ReleaseItem(
            R.drawable.release_info_product10,
            "New Balance",
            "New Balance 990v3 Made in USA Tan Green",
            end_of_release
        ),
        ReleaseItem(
            R.drawable.release_info_product11,
            "New Balance",
            "New Balance 990v1 Tan Green",
            end_of_release
        ),
        ReleaseItem(
            R.drawable.release_info_product12,
            "Adidas",
            "Adidas x Bodega x Beams Adimatic Off White Green",
            end_of_release
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReleaseInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val releaseItemAdapter = ReleaseItemAdapter(requireContext())
        releaseItemAdapter.setReleaseItemList(releaseItemList)

        val gridManager = GridLayoutManager(requireContext(), 2)
        binding.rvReleaseInfo.apply {
            layoutManager = gridManager
            adapter = releaseItemAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}