package com.ktknahmet.mobilium.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ktknahmet.mobilium.base.BaseViewModel
import com.ktknahmet.mobilium.model.movieDetail.MovieDetails
import com.ktknahmet.mobilium.model.nowPlaying.NowPlaying
import com.ktknahmet.mobilium.model.upcoming.UpcomingMovie
import com.ktknahmet.mobilium.services.NetworkResult
import com.ktknahmet.mobilium.services.TMDPInterface
import com.ktknahmet.mobilium.utils.SingleLiveEvent
import com.ktknahmet.mobilium.utils.getData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val apiService: TMDPInterface) : BaseViewModel() {

    val upcomingMovie : SingleLiveEvent<NetworkResult<UpcomingMovie>> = SingleLiveEvent()
    val liveDataNowPlaying : SingleLiveEvent<NetworkResult<NowPlaying>> = SingleLiveEvent()
    val liveDataMovieId :SingleLiveEvent<NetworkResult<MovieDetails>> = SingleLiveEvent()
    val dataLoading = MutableLiveData<Boolean>()


    fun getDataUpcoming(): LiveData<NetworkResult<UpcomingMovie>> {
        dataLoading.value = true
        viewModelScope.launch {
            apiService.getUpcomingMovie().getData(dataLoading){
                upcomingMovie.value = it
            }
        }
        return upcomingMovie
    }

    fun getDataNowPlaying(): LiveData<NetworkResult<NowPlaying>> {
        dataLoading.value = true
        viewModelScope.launch {
            apiService.getNowPlayingMovie().getData(dataLoading){
                liveDataNowPlaying.value = it
            }
        }
        return liveDataNowPlaying
    }
    fun getDataMovieDetails(id:Int): LiveData<NetworkResult<MovieDetails>> {
        dataLoading.value = true
        viewModelScope.launch {
            apiService.
            getMovieDetail(id).getData(dataLoading){
                liveDataMovieId.value = it
            }
        }
        return liveDataMovieId
    }
}


