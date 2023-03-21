package com.ktknahmet.mobilium.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.ktknahmet.mobilium.base.BaseFragment
import com.ktknahmet.mobilium.databinding.FragmentMovieDetailsBinding
import com.ktknahmet.mobilium.utils.myObserve
import com.ktknahmet.mobilium.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>(FragmentMovieDetailsBinding::inflate) {

    private val viewModel: MovieViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // getDetails()

    }
    private fun getDetails(){
        val movieId=arguments?.getInt("movieId")!!
        viewModel.getDataMovieDetails(movieId)
        viewModel.liveDataMovieId.myObserve(
            viewLifecycleOwner,
            success = {
                println("detaylar :$it")
            },
            error ={
                toastError(it)
            }
        )
    }
}