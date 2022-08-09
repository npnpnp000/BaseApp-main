package com.appa.dependency_injection

import com.appa.data.local.souce.MessagesLocalDataSource
import com.appa.data.remote.source.MessagesRemoteDataSource

object DataSourceModule {

    fun provideMessagesLocalDataSource(): MessagesLocalDataSource {
        return MessagesLocalDataSource(DaoModule.provideMessagesDao())
    }

    fun provideMessagesRemoteDataSource() : MessagesRemoteDataSource {
        return MessagesRemoteDataSource(NetworkModule.provideMessagesApi())
    }

}