package com.appa.dependency_injection

import com.appa.data.repositories.MessagesRepository

object RepositoryModule {

    fun provideMessagesRepository(): MessagesRepository {
        return MessagesRepository(
            DataSourceModule.provideMessagesLocalDataSource(),
            DataSourceModule.provideMessagesRemoteDataSource()
        )
    }
}