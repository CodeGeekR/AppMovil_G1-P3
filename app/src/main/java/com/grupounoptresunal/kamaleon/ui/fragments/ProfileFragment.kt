package com.grupounoptresunal.kamaleon.ui.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.grupounoptresunal.kamaleon.databinding.FragmentProfileBinding
import java.lang.Exception
import java.util.jar.Manifest


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val REQUEST_CAMERA_PERMISSION = 1
    private val REQUEST_IMAGE = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        checkPermission()
        events()
    }

    private fun events(){
        binding.profileImagen.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
                    try {
                        startActivityForResult(intent, REQUEST_IMAGE)
                    } catch (e: Exception) {

                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_IMAGE) {
                val bitmap = data?.extras?.get("data") as Bitmap
                binding.profileImagen.setImageBitmap(bitmap)
            }
        }
    }

    private fun checkPermission(){
        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CAMERA),
            REQUEST_CAMERA_PERMISSION)
        }
    }

}