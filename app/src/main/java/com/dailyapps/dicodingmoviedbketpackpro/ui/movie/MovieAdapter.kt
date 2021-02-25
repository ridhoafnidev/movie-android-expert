package com.dailyapps.dicodingmoviedbketpackpro.ui.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailyapps.dicodingmoviedbketpackpro.data.Movie
import com.dailyapps.dicodingmoviedbketpackpro.databinding.ItemsMovieBinding
import com.dailyapps.dicodingmoviedbketpackpro.utils.commons.Constants
import com.dailyapps.dicodingmoviedbketpackpro.utils.commons.Utils

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>(){

    private var onItemClickCallback: OnItemClickCallback?= null
    private val mData = ArrayList<Movie>()
    private var context: Context? = null
    private lateinit var callback: MovieCallback

    fun setData(item: ArrayList<Movie>, context: Context?, callback: MovieCallback) {
        this.context = context
        this.callback = callback
        mData.clear()
        mData.addAll(item)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Movie){
            with(binding){
                Utils().imageTopRound(binding.imagePoster, Constants.PATH.POSTER_PATCH+data.poster_path, context)
                labelTitle.text = data.title
                labelDate.text = data.release_date
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(data) }
                buttonShare.setOnClickListener { callback.onShareLink(data) }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemsMovieBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

}
