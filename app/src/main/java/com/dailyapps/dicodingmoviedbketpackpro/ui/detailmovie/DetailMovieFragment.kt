package com.dailyapps.dicodingmoviedbketpackpro.ui.detailmovie

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dailyapps.dicodingmoviedbketpackpro.MainActivity
import com.dailyapps.dicodingmoviedbketpackpro.R
import com.dailyapps.dicodingmoviedbketpackpro.data.Movie
import com.dailyapps.dicodingmoviedbketpackpro.databinding.FragmentDetailMovieBinding
import com.dailyapps.dicodingmoviedbketpackpro.utils.commons.Constants

class DetailMovieFragment : Fragment() {

    private var _binding: FragmentDetailMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailMovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        arguments?.let {
            var movie = DetailMovieFragmentArgs.fromBundle(it).data
            viewModel.setSelectedMovie(movie.id)
            getDetailMovie(viewModel.getMovie())
        }
    }

    private fun getDetailMovie(movie: Movie) {
        (activity as AppCompatActivity).supportActionBar?.setTitle(movie.title)
        Glide.with(this)
            .load("${Constants.PATH.POSTER_PATCH}${movie.poster_path}")
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
            )
            .into(binding.imageView)
        binding.labelTitleDes.text = movie.title
        binding.labelRealaseDes.text = "Release Date : ${movie.release_date}"
        binding.labelVoteDes.text = "Vote : ${movie.vote_average.toString()}"
        binding.labelOverviewDes.text = movie.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            (activity as MainActivity)?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity)?.hideBottomNavigation()
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity)?.showBottomNavigation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}