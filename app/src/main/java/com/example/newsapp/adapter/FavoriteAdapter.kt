package com.example.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.FavoriteItemBinding
import com.example.newsapp.model.news.Article
import com.squareup.picasso.Picasso

class FavoriteAdapter(
    var context: Context,
    var data: List<Article>,
    var itemClickListener: (view: View, news: Article) -> Unit
) :
    RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: FavoriteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setDataNote(data: Article) {
            binding.favoriteModel = data
        }

    }

    fun deleteNewsItem(position: Int) {
        notifyItemRemoved(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: FavoriteItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.favorite_item, parent, false
        )

        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article = Article(
            0,
            data[position].description,
            "",
            data[position].title,
            "",
            data[position].urlToImage
        )


        Picasso.get().load(data[position].urlToImage)
            .placeholder(R.drawable.ic_defualt_image).into(holder.binding.imgNews)
        holder.setDataNote(data[position])
        holder.itemView.setOnClickListener {
            itemClickListener(holder.binding.root, article)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

}