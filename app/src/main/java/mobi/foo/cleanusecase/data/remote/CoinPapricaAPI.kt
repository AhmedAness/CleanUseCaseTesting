package mobi.foo.cleanusecase.data.remote

import mobi.foo.cleanusecase.data.remote.dto.CoinDetailsDto
import mobi.foo.cleanusecase.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPapricaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String): CoinDetailsDto

}