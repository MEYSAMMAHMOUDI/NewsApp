package com.example.newsapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsDetailsFragmentBinding
import com.example.newsapp.model.news.Article
import com.example.newsapp.viewmodel.database.DatabaseViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment(R.layout.news_details_fragment) {
    private lateinit var binding: NewsDetailsFragmentBinding
    private val viewModelDatabase: DatabaseViewModel by viewModels()
    val args: NewsDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NewsDetailsFragmentBinding.bind(view)
        val article = args.argsNews
        binding.tvTitleDetails.text = article!!.title
        binding.tvDescriptionDetails.text = article.description

        Picasso.get().load(article.urlToImage).into(binding.imgDetails)
        viewModelDatabase.getAllNote().observe(viewLifecycleOwner, { listFavorit ->


            val news = Article(
                0,
                args.argsNews?.description,
                "",
                args.argsNews?.title,
                "",
                args.argsNews?.urlToImage
            )

            listFavorit.forEach {
                if (
                    news.title == it.title
                ) {
                    binding.fabFavorite.isEnabled = false
                } else {
                    binding.fabFavorite.isEnabled
                }

            }




            binding.fabFavorite.setOnClickListener {


                viewModelDatabase.insertNews(news)
                Snackbar.make(
                    view,
                    "با موفقیت به علاقه مندی ها اضافه شد",
                    Snackbar.LENGTH_SHORT
                )
                    .show()


            }

        })
    }
}

