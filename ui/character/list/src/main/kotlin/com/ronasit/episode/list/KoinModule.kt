package com.ronasit.episode.list

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterListModule = module {

    single { CharacterSource(get()) }

     viewModel { CharacterListViewModel(get()) }

}
