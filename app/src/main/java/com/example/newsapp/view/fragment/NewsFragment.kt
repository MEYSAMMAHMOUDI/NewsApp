package com.example.newsapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.NewsFragmentBinding
import com.example.newsapp.viewmodel.news.ViewModelNews
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.news_fragment) {
    private lateinit var binding: NewsFragmentBinding
    private lateinit var newsAdapter: NewsAdapter
    private val viewModelNews: ViewModelNews by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NewsFragmentBinding.bind(view)

        //  view.findNavController().navigate(NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment())


        binding.rvNews.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvNews.setHasFixedSize(true)

        viewModelNews.responseLiveData.observe(requireActivity(), {

                response ->

            if (viewModelNews.responseState) {
                binding.progressNews.visibility = View.INVISIBLE

                newsAdapter = NewsAdapter(
                    requireContext(),
                    response,
                    IItemClickListener = { itemClick, news ->
                        view.findNavController().navigate(NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment(news))
                    })
                binding.rvNews.adapter = newsAdapter
            } else {
                binding.progressNews.visibility = View.VISIBLE
            }

        })
    }


}