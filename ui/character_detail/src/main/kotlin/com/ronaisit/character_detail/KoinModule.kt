package com.ronaisit.character_detail

import com.ronaisit.character_detail.ui.CharacterDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterDetailModule = module {
    viewModel { parameters -> CharacterDetailViewModel(get(), get(), get(), id = parameters.get()) }
}
