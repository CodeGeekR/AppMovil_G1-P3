package com.grupounoptresunal.kamaleon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.grupounoptresunal.kamaleon.databinding.FragmentPasswordOlvidadoBinding
import com.grupounoptresunal.kamaleon.databinding.FragmentPasswordOlvidadoContinuarBinding


class PasswordOlvidadoContinuarFragment : Fragment() {
    private var _binding: FragmentPasswordOlvidadoContinuarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPasswordOlvidadoContinuarBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        //binding.buttonContinuarconfir.setOnClickListener() {
        //  findNavController().navigate(R.id.action_passwordOlvidadoFragment_to_passwordOlvidadoContinuarFragment)

        //}
        binding.buttonCancelarconfir.setOnClickListener() {
            findNavController().navigate(R.id.action_passwordOlvidadoContinuarFragment_to_loginFragment)

        }
    }

}