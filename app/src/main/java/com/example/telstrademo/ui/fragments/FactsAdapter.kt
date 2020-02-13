package com.example.telstrademo.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.telstrademo.R
import com.example.telstrademo.data.models.Facts
import com.example.telstrademo.databinding.RecyclerviewFactsBinding

class FactsAdapter (
    private val facts: List<Facts>
) : RecyclerView.Adapter<FactsAdapter.FactsViewHolder>(){

    override fun getItemCount() = facts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FactsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_facts,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
     /*   holder.recyclerviewMovieBinding.movie = facts[position]
        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.buttonBook, facts[position])
        }
        holder.recyclerviewMovieBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.layoutLike, facts[position])
        }*/
    }


    inner class FactsViewHolder(
        val recyclerviewMovieBinding: RecyclerviewFactsBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

}