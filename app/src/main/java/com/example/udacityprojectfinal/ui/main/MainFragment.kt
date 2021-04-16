package com.example.udacityprojectfinal.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacityprojectfinal.R
import com.example.udacityprojectfinal.databinding.FragmentMainBinding
import com.example.udacityprojectfinal.ui.welcome.WelcomeViewModel

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

        binding.mainViewModel = viewModel

        viewModel.eventNavigate.observe(viewLifecycleOwner, Observer { navigation ->
            if(navigation) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToUserFragment())
                viewModel.navigateComplete()
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}