package com.ronasit.location.list

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationListModule = module {
    single { parameters -> LocationSource(get(), text = parameters.get()) }
    single { LocationListState(get(), get(), get()) }
    viewModel { LocationListViewModel(get()) }
}
