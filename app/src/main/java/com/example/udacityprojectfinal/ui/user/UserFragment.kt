package com.example.udacityprojectfinal.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacityprojectfinal.R
import com.example.udacityprojectfinal.databinding.FragmentUserBinding
import com.example.udacityprojectfinal.ui.main.MainViewModel
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.viewModelUser = viewModel

        val user = UserFragmentArgs.fromBundle(requireArguments()).user

        binding.user = user

        viewModel.eventNavigateToRepositories.observe(viewLifecycleOwner, Observer { navigateToRepositories ->
            if(navigateToRepositories) {
                findNavController().navigate(UserFragmentDirections.actionUserFragmentToRepositoriesFragment(user))
                viewModel.navigateToRepositoriesComplete()
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}