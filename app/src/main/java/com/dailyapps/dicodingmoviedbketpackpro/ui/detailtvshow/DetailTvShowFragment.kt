package com.dailyapps.dicodingmoviedbketpackpro.ui.detailtvshow

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dailyapps.dicodingmoviedbketpackpro.MainActivity
import com.dailyapps.dicodingmoviedbketpackpro.R
import com.dailyapps.dicodingmoviedbketpackpro.data.Tv
import com.dailyapps.dicodingmoviedbketpackpro.databinding.DetailTvShowFragmentBinding
import com.dailyapps.dicodingmoviedbketpackpro.ui.detailmovie.DetailMovieFragmentDirections
import com.dailyapps.dicodingmoviedbketpackpro.utils.commons.Constants


class DetailTvShowFragment : Fragment() {

    private var _binding: DetailTvShowFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var tv: Tv
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailTvShowFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        arguments?.let {
            val tv = DetailTvShowFragmentArgs.fromBundle(it).data
            val viewModel = ViewModelProvider(this).get(DetailTvShowViewModel::class.java)
            viewModel.setSelectedTv(tv.id)
            val dataTv = viewModel.getTv()
            getDetailTv(dataTv)
        }
    }

    private fun getDetailTv(tv: Tv) {
        (activity as AppCompatActivity).supportActionBar?.setTitle(tv.name)
        Glide.with(this)
            .load("${Constants.PATH.POSTER_PATCH}${tv.poster_path}")
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
            )
            .into(binding.imageViewDes)
        binding.labelRealaseDes.text = "Release Date : ${tv.first_air_date}"
        binding.labelVoteDes.text = "Vote : ${tv.vote_average.toString()}"
        binding.labelTitleDes.text = tv.name
        binding.labelOverviewDes.text = tv.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            (activity as MainActivity)?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity)?.hideBottomNavigation()
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity)?.showBottomNavigation()
    }
}