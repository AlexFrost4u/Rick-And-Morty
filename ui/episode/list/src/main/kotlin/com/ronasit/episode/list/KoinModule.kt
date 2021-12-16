package com.ronasit.episode.list

import com.ronasit.episode.list.ui.EpisodeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeListModule = module {
    viewModel { EpisodeListViewModel(get()) }
}
