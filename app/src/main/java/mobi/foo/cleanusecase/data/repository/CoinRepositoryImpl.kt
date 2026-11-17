package mobi.foo.cleanusecase.data.repository

import javax.inject.Inject
import mobi.foo.cleanusecase.data.remote.CoinPapricaAPI
import mobi.foo.cleanusecase.data.remote.dto.CoinDetailsDto
import mobi.foo.cleanusecase.data.remote.dto.CoinDto
import mobi.foo.cleanusecase.domain.repository.CoinRepository

class CoinRepositoryImpl @Inject constructor(private val api: CoinPapricaAPI) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}