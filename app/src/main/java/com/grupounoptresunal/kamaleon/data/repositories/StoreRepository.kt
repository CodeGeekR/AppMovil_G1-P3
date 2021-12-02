package com.grupounoptresunal.kamaleon.data.repositories

import com.grupounoptresunal.kamaleon.data.mocks.StoreInfoMock
import com.grupounoptresunal.kamaleon.data.models.StoreInfo


class StoreRepository(private var dataSource: StoreInfoMock) {
    suspend fun loadinfo(): StoreInfo{
        return dataSource.loadInfo()
    }
}