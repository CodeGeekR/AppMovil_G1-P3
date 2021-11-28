package com.grupounoptresunal.kamaleon.di

import com.grupounoptresunal.kamaleon.data.repositories.CommentRepository
import com.grupounoptresunal.kamaleon.data.repositories.ProductRepository
import com.grupounoptresunal.kamaleon.data.repositories.StoreRepository
import org.koin.dsl.module

val repoModule = module {
    single { StoreRepository(get()) }
    single { ProductRepository(get()) }
    single { CommentRepository(get())}
}