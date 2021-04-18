package com.example.udacityprojectfinal.ui.historic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacityprojectfinal.databinding.FragmentHistoricBinding

class HistoricFragment : Fragment() {

    private lateinit var binding: FragmentHistoricBinding

    private val viewModel: HistoricViewModel by lazy {
        ViewModelProvider(this).get(HistoricViewModel::class.java)
    }

    private val adapter = HistoricAdapter(onCLickListenerNavigate())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHistoricBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.reposViewModel = viewModel

        binding.recyclerView.adapter = adapter

        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            if (users != null) {
                adapter.submitList(users)
            }
        })

        viewModel.navigateUser.observe(viewLifecycleOwner, Observer { user ->
            if (user != null) {
                this.findNavController()
                    .navigate(HistoricFragmentDirections.actionHistoricFragmentToUserFragment(user))
                viewModel.navigateComplete()
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun onCLickListenerNavigate() = HistoricAdapter.OnClickListener { user ->
        viewModel.navigate(user)
    }
}