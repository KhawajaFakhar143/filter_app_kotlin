package com.example.filterapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.filterapp.databinding.ItemFilterContainerBinding
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter

class FiltersAdapter(val filterList: ArrayList<ImageFilters>, val filter: (GPUImageFilter)-> Unit): RecyclerView.Adapter<FiltersAdapter.MainViewHolder>() {

    inner class MainViewHolder(binding: ItemFilterContainerBinding ) : RecyclerView.ViewHolder(binding.root) {
        val view: View = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemFilterContainerBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val view: View = holder.view
        view.findViewById<TextView>(R.id.filters_name).text = filterList[position].name
        view.findViewById<CardView>(R.id.card_view_filter).setOnClickListener {
            filter.invoke(filterList[position].filters)
        }

    }

    override fun getItemCount(): Int {
        return filterList.size
    }
}