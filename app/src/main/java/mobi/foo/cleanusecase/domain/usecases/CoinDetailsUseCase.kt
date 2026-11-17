package mobi.foo.cleanusecase.domain.usecases

import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mobi.foo.cleanusecase.common.Resource
import mobi.foo.cleanusecase.domain.model.CoinDetails
import mobi.foo.cleanusecase.domain.repository.CoinRepository

class CoinDetailsUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetails>> = flow {
        emit(Resource.Loading())
        try {
            val coin = coinRepository.getCoinById(coinId).toDomain()
            emit(Resource.Success(coin))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IOException in CardDetailsUseCase"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Exception in CardDetailsUseCase"))
        }
    }
}