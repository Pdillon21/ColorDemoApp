package com.example.colordemoapp.common

sealed class ColorsResponse<T> (val data : T? = null, val message : String? = null){
    class Success<T>(data: T?) : ColorsResponse<T>(data)
    class Error<T>(message: String?,data: T? = null) : ColorsResponse<T>(data,message)
    class Loading<T>(message: String? = null) : ColorsResponse<T>()
}
