package com.example.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.model.news.Article
import com.example.newsapp.model.news.NewsModel
import com.squareup.picasso.Picasso

class NewsAdapter(
    var context: Context,
    var data: NewsModel,
    var IItemClickListener: (view: View, news: Article) -> Unit
) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setDataImages(data: Article) {
            binding.newModel = data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: NewsItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.news_item, parent, false
        )

        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Picasso.get().load(data.articles[position].urlToImage)
            .placeholder(R.drawable.ic_defualt_image).into(holder.binding.imgNews)
        holder.setDataImages(data.articles[position])
        holder.itemView.setOnClickListener {

            IItemClickListener(holder.binding.root, data.articles[position])

        }
    }

    override fun getItemCount(): Int {
        return data.articles.size
    }

}