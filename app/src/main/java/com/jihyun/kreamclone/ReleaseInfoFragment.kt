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