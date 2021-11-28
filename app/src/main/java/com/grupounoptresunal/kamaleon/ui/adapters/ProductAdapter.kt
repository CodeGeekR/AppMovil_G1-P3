package com.grupounoptresunal.kamaleon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grupounoptresunal.kamaleon.data.models.Comment
import com.grupounoptresunal.kamaleon.ui.listeners.OnProductListener
import com.grupounoptresunal.kamaleon.data.models.Product
import com.grupounoptresunal.kamaleon.databinding.ItemProductBinding

class ProductAdapter(var items: List<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    var  listener : OnProductListener? =null
    class ViewHolder(var item:ItemProductBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =items[position]
        holder.item.itemProductName.text = item.name
        holder.item.itemProductPrice.text = item.price
        Glide.with(holder.itemView).load(item.image).into(holder.item.itemProductPhoto)
        holder.item.root.setOnClickListener{
            listener?.OnClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun newDataSet(newProducts: List<Product>){
        items = newProducts
        notifyDataSetChanged()
    }
}