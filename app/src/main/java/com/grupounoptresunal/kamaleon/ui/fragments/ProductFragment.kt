package com.grupounoptresunal.kamaleon.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.grupounoptresunal.kamaleon.R
import com.grupounoptresunal.kamaleon.ui.listeners.OnProductListener
import com.grupounoptresunal.kamaleon.data.models.Product
import com.grupounoptresunal.kamaleon.databinding.FragmentProductBinding
import com.grupounoptresunal.kamaleon.ui.adapters.ProductAdapter
import com.grupounoptresunal.kamaleon.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productManager: GridLayoutManager
    private val productsViewModels: ProductViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_product, container, false)
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        productsViewModels.loadProducts()
            productAdapter= ProductAdapter(
                listOf()
            )
        productManager = GridLayoutManager(requireContext(),1)
        productAdapter.listener = object : OnProductListener {
            override fun OnClick(item: Product) {
                Log.d("Product", item.name )
                productsViewModels.selectProduct(item)
                findNavController().navigate(R.id.action_productFragment_to_productDetailFragment2)
            }

        }
        binding.productRecycler.apply {
            adapter = productAdapter
            layoutManager = productManager
        }
        observeViewModels()
    }
    private fun observeViewModels(){
        productsViewModels.products.observe(viewLifecycleOwner, Observer { products ->
            productAdapter.newDataSet(products)

        })
    }

}