package com.ktknahmet.mobilium.services



import com.ktknahmet.mobilium.model.movieDetail.MovieDetails
import com.ktknahmet.mobilium.model.nowPlaying.NowPlaying
import com.ktknahmet.mobilium.model.upcoming.UpcomingMovie
import com.ktknahmet.mobilium.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TMDPInterface {

    @GET("movie/{movie_id}?api_key=${AppConstants.APIKEY}")
    fun getMovieDetail(
        @Path("movie_id") id:Int
    ): Response<MovieDetails>


    @GET("movie/upcoming/?api_key=${AppConstants.APIKEY}")
    suspend fun getUpcomingMovie(
    ): Response<UpcomingMovie>

    @GET("movie/now_playing/?api_key=${AppConstants.APIKEY}")
    suspend fun getNowPlayingMovie(
    ): Response<NowPlaying>
}