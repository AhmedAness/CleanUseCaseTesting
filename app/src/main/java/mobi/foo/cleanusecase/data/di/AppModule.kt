package mobi.foo.cleanusecase.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import mobi.foo.cleanusecase.common.Constants
import mobi.foo.cleanusecase.data.remote.CoinPapricaAPI
import mobi.foo.cleanusecase.data.repository.CoinRepositoryImpl
import mobi.foo.cleanusecase.domain.repository.CoinRepository
import mobi.foo.cleanusecase.domain.usecases.CoinDetailsUseCase
import mobi.foo.cleanusecase.domain.usecases.CoinUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApi(): CoinPapricaAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPapricaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPapricaAPI): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCoinsUseCase(coinRepository: CoinRepository): CoinUseCase {
        return CoinUseCase(coinRepository)
    }

    @Provides
    @Singleton
    fun provideCoinDetailsUseCase(coinRepository: CoinRepository): CoinDetailsUseCase {
        return CoinDetailsUseCase(coinRepository)
    }

}