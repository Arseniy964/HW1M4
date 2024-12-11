package com.arseniy.hw1m4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arseniy.hw1m4.R
import com.arseniy.hw1m4.databinding.FragmentOnBoardViewPagerBinding


class OnBoardViewPagerFragment : Fragment() {

    private lateinit var binding:  FragmentOnBoardViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize(): Unit = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                animationView.setAnimation(R.raw.lottie1)
                tvTitle.text = "Удобство"
                tvDescription.text = "Cоздавайте заметки в два клика!Записывайте мысли идеи и важные задачи."
            }

            1 -> {
                animationView.setAnimation(R.raw.lottia2)
                tvTitle.text = "Организация"
                tvDescription.text = "Организуйте заметки по папкам и тегам.Легко находите нужную информация в любое время."
            }

            2 -> {
                animationView.setAnimation(R.raw.lottia3)
                tvTitle.text = "Синхронизация"
                tvDescription.text = "Синхронизация на всех устройствах.Доступ к записям в любое время и в любом месте."
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}