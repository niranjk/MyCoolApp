package com.niranjan.mycoolapp.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {
    // single instance of KoinRepository
    single<KoinService> {  KoinRepository() }

    // provide dependency
    viewModel { KoinViewModel(get()) }
}

val anotherModule = module {
    // new instance in each injection
    factory<KoinService> { KoinRepository() }
}