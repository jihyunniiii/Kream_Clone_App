package com.jihyun.kreamclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jihyun.kreamclone.databinding.FragmentWomenBinding

class WomenFragment : Fragment() {
    private var _binding: FragmentWomenBinding? = null
    private val binding: FragmentWomenBinding
        get() = requireNotNull(_binding)

    private var womenList = listOf(
        womenItem(
            type_shortcut,
            R.drawable.women_new,
            "New",
            null,
            null,
            null
        ),
        womenItem(
            type_shortcut,
            R.drawable.women_luxury,
            "럭셔리",
            null,
            null,
            null
        ),
        womenItem(
            type_shortcut,
            R.drawable.women_popular_shoes,
            "인기 신발",
            null,
            null,
            null
        ),
        womenItem(
            type_shortcut,
            R.drawable.women_celeb_pick,
            "셀럽픽",
            null,
            null,
            null
        ),
        womenItem(
            type_shortcut,
            R.drawable.women_small_luxury,
            "스몰 럭셔리",
            null,
            null,
            null
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
        val layoutManager = StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL)
        binding.rvWomen.layoutManager = layoutManager

        val adapter = WomenAdapter(requireContext())
        binding.rvWomen.adapter = adapter
        adapter.setWomenList(womenList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}