package com.grupounoptresunal.kamaleon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.grupounoptresunal.kamaleon.R
import com.grupounoptresunal.kamaleon.databinding.FragmentProductBinding
import com.grupounoptresunal.kamaleon.databinding.FragmentProductDetailBinding
import com.grupounoptresunal.kamaleon.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_product_detail, container, false)
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observerViewModels()
    }
    private fun observerViewModels(){
        productViewModel.selected.observe(viewLifecycleOwner, Observer { product ->
            binding.titleproductdetail.text = product.name
            binding.descrptionproducdetail.text = product.description
            binding.priceproducdetail.text = product.price
            Glide.with(binding.root).load(product.image).into(binding.imageproductdetail)

        })
    }
}