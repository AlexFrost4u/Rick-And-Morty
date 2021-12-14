package com.ronasit.ui.episode.detail

import com.ronasit.ui.episode.detail.ui.EpisodeDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeDetailModule = module {
    viewModel { parameters -> EpisodeDetailViewModel(get(), get(), id = parameters.get()) }
}
