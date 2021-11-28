package com.grupounoptresunal.kamaleon.di

import com.grupounoptresunal.kamaleon.data.mocks.CommentMock
import com.grupounoptresunal.kamaleon.data.mocks.ProductMocks
import com.grupounoptresunal.kamaleon.data.mocks.StoreInfoMock
import org.koin.dsl.module

val dataSourceModule = module {
    single { CommentMock() }
    single { ProductMocks() }
    single { StoreInfoMock() }
}