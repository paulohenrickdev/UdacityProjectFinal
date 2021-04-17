package com.example.udacityprojectfinal.ui.repositories

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.udacityprojectfinal.R
import com.example.udacityprojectfinal.databinding.FragmentMainBinding
import com.example.udacityprojectfinal.databinding.FragmentRepositoriesBinding
import com.example.udacityprojectfinal.model.User

class RepositoriesFragment : Fragment() {

    private lateinit var binding: FragmentRepositoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application

        binding = FragmentRepositoriesBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val user = RepositoriesFragmentArgs.fromBundle(requireArguments()).user

        val viewModelFactory = RepositoryViewModelFactory(user!!, application)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(RepositoriesViewModel::class.java)

        binding.reposViewModel = viewModel

        val adapter = RepositoryAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.reposList.observe(viewLifecycleOwner, Observer { repos ->
           adapter.submitList(repos)
        })

        // Inflate the layout for this fragment
        return binding.root
    }

}

class RepositoryViewModelFactory(
    private val user: User,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoriesViewModel::class.java)) {
            return RepositoriesViewModel(user, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}