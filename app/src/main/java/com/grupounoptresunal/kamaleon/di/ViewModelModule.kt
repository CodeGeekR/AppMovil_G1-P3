package com.grupounoptresunal.kamaleon.di

import com.grupounoptresunal.kamaleon.ui.viewmodels.CommentViewModel
import com.grupounoptresunal.kamaleon.ui.viewmodels.ProductViewModel
import com.grupounoptresunal.kamaleon.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { StoreViewModel(get()) }
    viewModel { ProductViewModel(get())}
    viewModel { CommentViewModel(get()) }

}