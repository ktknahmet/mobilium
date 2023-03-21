package com.ktknahmet.mobilium.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.crazylegend.kotlinextensions.views.gone
import com.crazylegend.kotlinextensions.views.visible
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.ktknahmet.mobilium.R
import com.ktknahmet.mobilium.adapter.UpcomingAdapter
import com.ktknahmet.mobilium.base.BaseFragment
import com.ktknahmet.mobilium.databinding.FragmentMovieListBinding
import com.ktknahmet.mobilium.utils.AppConstants
import com.ktknahmet.mobilium.utils.myObserve
import com.ktknahmet.mobilium.utils.navigate
import com.ktknahmet.mobilium.utils.observeProgress
import com.ktknahmet.mobilium.utils.recyclerview.itemClick
import com.ktknahmet.mobilium.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate){
    private val viewModel : MovieViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swiperefresh.setOnRefreshListener {
            binding.recyclerview.gone()
            upcoming()
            binding.swiperefresh.isRefreshing=false

        }

        nowPlaying()
        upcoming()
    }
    private fun nowPlaying(){
        val imageList = ArrayList<SlideModel>()
        viewModel.getDataNowPlaying()
        viewModel.dataLoading.observeProgress(viewLifecycleOwner,binding.pgBar)
        viewModel.liveDataNowPlaying.myObserve(
            viewLifecycleOwner,
            success = {
                for(i in it.results){
                    imageList.add(SlideModel(AppConstants.POSTER_BASEURL+i.posterPath, i.title))
                }
                binding.slider.setImageList(imageList,ScaleTypes.CENTER_CROP)

            },
            error = {
                toastError(it)
            }
        )
    }
    private fun upcoming(){
        viewModel.getDataUpcoming()
        viewModel.dataLoading.observeProgress(viewLifecycleOwner,binding.pgBar)
        viewModel.upcomingMovie.myObserve(
            viewLifecycleOwner,
            success = {
                val mAdapter = UpcomingAdapter(it)
                binding.recyclerview.visible()
                binding.recyclerview.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    this.adapter = mAdapter
                }
                val args = Bundle()

                binding.recyclerview.itemClick { _, position ->
                   val movieId= mAdapter.getList()[position].id
                    println("movie id :$movieId")
                    args.putInt("movieId", movieId)
                    navigate(R.id.action_movieList_to_movieDetails,args)
                }

            },
            empty = {
                toastError("liste boş")
            },
            error = {
                toastError(it)
            }
        )
    }

}