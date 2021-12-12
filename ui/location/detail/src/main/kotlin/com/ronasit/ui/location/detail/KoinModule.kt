package com.ronasit.ui.location.detail


import com.ronasit.ui.location.detail.ui.LocationDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationDetailModule = module {
    viewModel { LocationDetailViewModel(get(), get()) }
}
