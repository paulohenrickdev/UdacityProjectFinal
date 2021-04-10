package com.example.udacityprojectfinal.ui.instructions

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacityprojectfinal.R
import com.example.udacityprojectfinal.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding
    private lateinit var viewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstructionsBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)

        val animator = ObjectAnimator.ofFloat(binding.goToSearchUser, View.ALPHA, 0f)
        animator.repeatCount = 1
        animator.duration = 1000
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

        binding.instructionsViewModel = viewModel

        viewModel.eventNavigateInstructions.observe(viewLifecycleOwner, Observer { navigateToSearchUser ->
            if(navigateToSearchUser) {
                findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToMainFragment())
            }
        })

        return binding.root
    }

}