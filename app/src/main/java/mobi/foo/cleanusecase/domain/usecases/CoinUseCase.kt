package mobi.foo.cleanusecase.domain.usecases

import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mobi.foo.cleanusecase.common.Resource
import mobi.foo.cleanusecase.domain.model.Coin
import mobi.foo.cleanusecase.domain.repository.CoinRepository

class CoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        try {
            val coin = coinRepository.getCoins().map { it.toDomain() }
            emit(Resource.Success(coin))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IOException in CardDetailsUseCase"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Exception in CardDetailsUseCase"))
        }
    }
}