package com.javohirbekcoder.puzzle15mvp.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.javohirbekcoder.puzzle15mvp.R
import com.javohirbekcoder.puzzle15mvp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)

        val navController = findNavController()

        binding.playBtn.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_gameFragment)
        }
        binding.recordsBtn.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_recordsFragment)
        }
        binding.settingsBtn.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        binding.aboutBtn.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_aboutFragment)
        }
        binding.exitBtn.setOnClickListener {
            //Exit
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}