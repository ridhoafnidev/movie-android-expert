package com.dailyapps.dicodingmoviedbketpackpro.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dailyapps.dicodingmoviedbketpackpro.R
import com.dailyapps.dicodingmoviedbketpackpro.data.Movie
import com.dailyapps.dicodingmoviedbketpackpro.databinding.FragmentMovieBinding

class MovieFragment : Fragment(), MovieCallback {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        binding.progressBar.visibility = View.VISIBLE
        val movies = movieViewModel.getMovie()
        val adapter = MovieAdapter()
        adapter.notifyDataSetChanged()
        if (movies != null){
            binding.progressBar.visibility = View.GONE
            adapter.setData(movies, context, this)
        }else{
            binding.progressBar.visibility = View.GONE
            adapter.setData(ArrayList(), context, this)
        }
        with(binding.recyclerViewMovie) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            this.adapter = adapter
        }
        adapter.setOnItemClickCallback(object: MovieAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Movie) {
                val toDetailFragment = MovieFragmentDirections.actionNavigationMovieToDetailFragment(data)
                findNavController().navigate(toDetailFragment)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onShareLink(movie: Movie) {
        activity?.let {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(it)
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, movie.title))
                .startChooser()
        }
    }
}