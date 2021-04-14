package com.example.udacityprojectfinal.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.fragment.findNavController
import com.example.udacityprojectfinal.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)

        val motionLayout = requireActivity().findViewById<MotionLayout>(R.id.motionLayout)
        
        motionLayout.addTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                TODO("Not yet implemented")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                TODO("Not yet implemented")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
//                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                TODO("Not yet implemented")
            }

        })
    }

}