package com.arseniy.hw1m4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.arseniy.hw1m4.R
import com.arseniy.hw1m4.databinding.ActivityMainBinding
import com.arseniy.hw1m4.databinding.FragmentOnboardBinding
import com.google.android.material.tabs.TabLayout.Tab
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnboardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun setupListeners() = with(binding.ViewPager) {
        binding.ViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    binding.tvSkip.visibility = View.INVISIBLE
                    binding.btnStart.visibility = View.VISIBLE
                } else {
                    binding.tvSkip.visibility = View.VISIBLE
                    binding.btnStart.visibility = View.GONE
                }
            }
        })
        binding.tvSkip.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }
        }
        binding.btnStart.setOnClickListener {
            if (binding.ViewPager.currentItem == 2) {
                findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
            }
        }
    }

    private fun initialize() {
        val adapter = OnBoardViewPagerAdapter(this)
        binding.ViewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.ViewPager) { tab, position -> tab.text = "$position"

        }.attach()
    }
}