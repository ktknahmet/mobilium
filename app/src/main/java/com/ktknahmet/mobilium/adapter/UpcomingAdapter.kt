package com.ktknahmet.mobilium.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ktknahmet.mobilium.databinding.UpcomingRowBinding
import com.ktknahmet.mobilium.model.upcoming.Result
import com.ktknahmet.mobilium.model.upcoming.UpcomingMovie
import com.ktknahmet.mobilium.utils.AppConstants
import com.ktknahmet.mobilium.utils.dateFormat2
import com.squareup.picasso.Picasso

class UpcomingAdapter (private val alldata:UpcomingMovie):
    RecyclerView.Adapter<UpcomingAdapter.DetailsHolder>() {
    private var list:List<Result> = ArrayList()
    init {
        list = alldata.results
    }


    class DetailsHolder(val binding: UpcomingRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsHolder{
        val binding = UpcomingRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //bağlama işlemi
        return DetailsHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DetailsHolder, position: Int) {

         with(holder){
            val p: Result = list[position]
            binding.movies = p
        }
    }

    override fun getItemCount(): Int {
        return alldata.results.size
    }
    fun getList(): List<Result> = list

}