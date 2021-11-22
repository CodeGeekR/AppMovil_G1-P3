package com.grupounoptresunal.kamaleon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.grupounoptresunal.kamaleon.databinding.FragmentLoginBinding



/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonRegisLogin.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment2)


        }
        binding.buttonOlvidePassword.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_passwordOlvidadoFragment2)

        }
    }


}