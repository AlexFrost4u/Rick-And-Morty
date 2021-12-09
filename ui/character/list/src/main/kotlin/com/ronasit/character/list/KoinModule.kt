package com.ronasit.character.list

import com.ronasit.character.list.ui.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterListModule = module {
    viewModel { CharacterListViewModel(get()) }
}
