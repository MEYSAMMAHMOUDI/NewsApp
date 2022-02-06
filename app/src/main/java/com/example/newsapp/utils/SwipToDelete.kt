package com.example.newsapp.utils

import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapter.FavoriteAdapter
import com.example.newsapp.model.news.Article
import com.example.newsapp.viewmodel.database.DatabaseViewModel
import com.google.android.material.snackbar.Snackbar

class SwipToDelete(
    val article: List<Article>,
    val favoriteAdapter: FavoriteAdapter,
    val viewModelDatabase: DatabaseViewModel,
    val view: View
) : ItemTouchHelper.SimpleCallback(0, LEFT or RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ) = true

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        var itemPosition = viewHolder.adapterPosition
        favoriteAdapter.deleteNewsItem(itemPosition)
        val items = article[itemPosition]
        viewModelDatabase.deleteNews(items)
        Snackbar.make(view, "اخبار با موفقیت حذف شد", Snackbar.LENGTH_SHORT).apply {
            setAction("لغو عملیات") {
                viewModelDatabase.insertNews(items)
            }
            show()
        }
    }
}