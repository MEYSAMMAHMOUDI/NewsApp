package com.example.newsapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.newsapp.R
import com.example.newsapp.adapter.FavoriteAdapter
import com.example.newsapp.databinding.FavoriteFragmentBinding
import com.example.newsapp.model.news.Article
import com.example.newsapp.utils.SwipToDelete
import com.example.newsapp.viewmodel.database.DatabaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.favorite_fragment) {
    private lateinit var binding: FavoriteFragmentBinding
    private val viewModelDatabase: DatabaseViewModel by viewModels()
    private lateinit var favoriteAdapter: FavoriteAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FavoriteFragmentBinding.bind(view)
        setupRecyclerAdapter()
        viewModelDatabase.getAllNote().observe(viewLifecycleOwner, { data ->

            favoriteAdapter = FavoriteAdapter(
                requireContext(),
                data,
                itemClickListener = {


                })
            swipTOdeleteNews(data, favoriteAdapter, viewModelDatabase, view)
            binding.rvFavorite.adapter = favoriteAdapter


        })


    }

    fun setupRecyclerAdapter() {
        binding.apply {
            binding.rvFavorite.layoutManager = GridLayoutManager(requireContext(), 1)
            binding.rvFavorite.hasFixedSize()
        }
    }

    fun swipTOdeleteNews(
        article: List<Article>,
        favoriteAdapter: FavoriteAdapter,
        databaseViewModel: DatabaseViewModel,
        view: View
    ) {
        val itemDelete =
            ItemTouchHelper(SwipToDelete(article, favoriteAdapter, databaseViewModel, view))
        itemDelete.attachToRecyclerView(binding.rvFavorite)
    }
}