package com.example.telstrademo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.telstrademo.R
import com.example.telstrademo.data.networks.FactsApi
import com.example.telstrademo.data.repositories.FactsRepository
import kotlinx.android.synthetic.main.facts_fragment.*
import net.simplifiedcoding.ui.movies.FactsViewModelFactory


class FactsFragment : Fragment(){

    private lateinit var factory: FactsViewModelFactory
    private lateinit var viewModel: FactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.facts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = FactsApi()
        val repository = FactsRepository(api)

        factory = FactsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(FactsViewModel::class.java)

        viewModel.getFactsData()

        viewModel.facts.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = FactsAdapter(movies)
            }
        })
    }


}
