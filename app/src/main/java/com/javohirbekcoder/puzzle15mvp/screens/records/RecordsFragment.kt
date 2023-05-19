package com.javohirbekcoder.puzzle15mvp.screens.records

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.javohirbekcoder.puzzle15mvp.R
import com.javohirbekcoder.puzzle15mvp.databinding.FragmentRecordsBinding

class RecordsFragment : Fragment(R.layout.fragment_records) {

    private var _binding: FragmentRecordsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecordsBinding.inflate(inflater)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}