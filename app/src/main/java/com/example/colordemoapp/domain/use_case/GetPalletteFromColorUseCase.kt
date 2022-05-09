package com.example.colordemoapp.domain.use_case

import com.example.colordemoapp.common.ColorsResponse
import com.example.colordemoapp.domain.repository.ColorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPalletteFromColorUseCase @Inject constructor(

    private val repository: ColorsRepository) {

    operator fun invoke(hexColor : String) : Flow<ColorsResponse<List<String>>> = flow {
        try {
            emit(ColorsResponse.Loading<List<String>>("Fetching palette"))
            val colors = repository.getPaletteFromColor(hexColor)
            emit(ColorsResponse.Success<List<String>>(colors))
        } catch (e : HttpException) {
            emit(ColorsResponse.Error<List<String>>(e.localizedMessage ?: "Unexpected Error"))
        } catch (e : IOException) {
            emit(ColorsResponse.Error<List<String>>(e.localizedMessage ?: "Server Error"))
        }
    }
}