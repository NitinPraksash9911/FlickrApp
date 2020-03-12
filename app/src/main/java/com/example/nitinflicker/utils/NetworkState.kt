package com.example.nitinflicker.utils


/**
 * Created by  Nitin on 2020-03-12.
 */


enum class Status {

    RUNNING,
    SUCESS,
    FAILED
}


class NetworkState(val status: Status, val messgae: String) {

    companion object {

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(Status.SUCESS, "success")
            LOADING = NetworkState(Status.RUNNING, "loading")

            ERROR = NetworkState(Status.FAILED, "something went wrong")
        }

    }


}