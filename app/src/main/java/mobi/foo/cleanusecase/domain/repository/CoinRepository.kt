package mobi.foo.cleanusecase.domain.repository

import mobi.foo.cleanusecase.data.remote.dto.CoinDetailsDto
import mobi.foo.cleanusecase.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String): CoinDetailsDto

}