package com.example.udacityprojectfinal.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacityprojectfinal.R
import com.example.udacityprojectfinal.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)

        setHasOptionsMenu(true)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.mainViewModel = viewModel

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            if (user != null) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToUserFragment(user))
                viewModel.navigateComplete()
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            if (error) {
                Toast.makeText(context, getString(R.string.error_call_api), Toast.LENGTH_SHORT)
                    .show()
            }
        })

        viewModel.eventNavigateToHist.observe(viewLifecycleOwner, Observer { navigate ->
            if(navigate) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToHistoricFragment())
                viewModel.navigateToHistComplete()
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}