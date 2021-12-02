package com.grupounoptresunal.kamaleon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.grupounoptresunal.kamaleon.R
import com.grupounoptresunal.kamaleon.databinding.FragmentPasswordOlvidadoBinding


class PasswordOlvidadoFragment : Fragment() {

    private var _binding: FragmentPasswordOlvidadoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPasswordOlvidadoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        binding.buttonContinuarOlv.setOnClickListener() {
            findNavController().navigate(R.id.action_passwordOlvidadoFragment_to_passwordOlvidadoContinuarFragment)

        }
        binding.buttonCancelarOlv.setOnClickListener() {
            findNavController().navigate(R.id.action_passwordOlvidadoFragment_to_loginFragment)

        }
    }
}