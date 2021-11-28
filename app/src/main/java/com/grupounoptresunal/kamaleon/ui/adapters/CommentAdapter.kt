package com.grupounoptresunal.kamaleon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grupounoptresunal.kamaleon.data.models.Comment
import com.grupounoptresunal.kamaleon.databinding.ItemCommentBinding

class CommentAdapter(var items: List<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    class ViewHolder(var item: ItemCommentBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.item.itemCommentName.text = item.author
        holder.item.itemCommentTex.text = item.description
        holder.item.itemCommentData.text = item.data
        Glide.with(holder.itemView).load(item.image).into(holder.item.itemCommentPhoto)
    }
    fun newDataSet(newComments: List<Comment>){
        items = newComments
        notifyDataSetChanged()
    }
}