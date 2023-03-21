package com.ktknahmet.mobilium.services


sealed class NetworkResult<ResultType> {

    /**
     * Describes success state of the UI with
     * [data] shown
     */
    data class Success<ResultType>(
        val data: ResultType
    ) : NetworkResult<ResultType>()


    data class Error<ResultType>(
        val message: String = ""
    ) : NetworkResult<ResultType>()

    data class Empty<ResultType>(
        val message: String = ""
    ) : NetworkResult<ResultType>()
    companion object {

        fun <ResultType> success(data: ResultType): NetworkResult<ResultType> = Success(data)

        fun <ResultType> error(message: String): NetworkResult<ResultType> = Error(message)

        fun <ResultType> empty(message: String): NetworkResult<ResultType> = Empty(message)
    }
}