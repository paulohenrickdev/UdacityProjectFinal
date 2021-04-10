package com.example.udacityprojectfinal.ui.welcome

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacityprojectfinal.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWelcomeBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel

        val animator = ObjectAnimator.ofFloat(binding.goToInstructions, View.ALPHA, 0f)
        animator.repeatCount = 1
        animator.duration = 1000
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

        viewModel.eventNavigateInstructions.observe(viewLifecycleOwner, Observer { navigateToInstruction ->
           if(navigateToInstruction) {
               findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
               viewModel.navigateToInstructionComplete()
           }
        })

        return binding.root
    }
}