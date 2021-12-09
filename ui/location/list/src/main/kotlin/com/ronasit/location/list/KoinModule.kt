package com.ronasit.location.list

import com.ronasit.location.list.ui.LocationListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationListModule = module {
    viewModel { LocationListViewModel(get()) }
}
