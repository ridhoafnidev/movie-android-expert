package com.dailyapps.dicodingmoviedbketpackpro.ui.tvshow

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
import com.dailyapps.dicodingmoviedbketpackpro.data.Tv
import com.dailyapps.dicodingmoviedbketpackpro.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment(), TvShowCallback {
    private lateinit var movieViewModel: TvShowViewModel
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TvShowAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)
        initAdapter()
        initRecycler()
        getData()
    }

    private fun getData() {
        val movies = movieViewModel.getTvShow()
        binding.progressBar.visibility = View.VISIBLE
        if (!movies.isEmpty()){
            binding.progressBar.visibility = View.GONE
            adapter.setData(movies, context, this)
        }else{
            binding.progressBar.visibility = View.GONE
            adapter.setData(ArrayList(), context, this)
        }
        adapter.setOnItemClickCallback(object: TvShowAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Tv) {
                val toDetailFragment = TvShowFragmentDirections.actionNavigationTvShowToDetailTvShowFragment(data)
                findNavController().navigate(toDetailFragment)
            }
        })
    }

    private fun initRecycler() {
        binding.recyclerViewTv.setHasFixedSize(true)
        binding.recyclerViewTv.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerViewTv.adapter = adapter
    }

    private fun initAdapter() {
        adapter = TvShowAdapter()
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onShareLink(tv: Tv) {
        activity?.let {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(it)
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, tv.name))
                .startChooser()
        }
    }
}