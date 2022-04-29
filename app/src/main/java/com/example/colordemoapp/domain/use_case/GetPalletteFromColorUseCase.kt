package com.example.colordemoapp.domain.use_case

import com.example.colordemoapp.common.ColorsResponse
import com.example.colordemoapp.data.remote.dto.ColorHexDto
import com.example.colordemoapp.domain.repository.ColorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPalletteFromColorUseCase @Inject constructor(

    private val repository: ColorsRepository) {

    operator fun invoke(hexColor : String, monochromeValue : String) : Flow<ColorsResponse<List<ColorHexDto>>> = flow {
        try {
            emit(ColorsResponse.Loading("Fetching palette"))
            val colors = repository.getPaletteFromColor(hexColor,monochromeValue)
            emit(ColorsResponse.Success(colors))
        } catch (e : HttpException) {
            emit(ColorsResponse.Error(e.localizedMessage ?: "Unexpected Error"))
        } catch (e : IOException) {
            emit(ColorsResponse.Error(e.localizedMessage ?: "Server Error"))
        }
    }
}