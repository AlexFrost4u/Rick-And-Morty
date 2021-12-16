package com.ronasit.ui.location.detail.ui

import androidx.lifecycle.ViewModel
import com.ronasit.feature.rickandmorty_api.usecase.GetCharacterListUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetLocationUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class LocationDetailViewModel(
    private val getLocationDetailUseCase: GetLocationUseCase,
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val id: String
) : ViewModel(), ContainerHost<LocationDetailState, LocationDetailSideEffect> {
    override val container = container<LocationDetailState, LocationDetailSideEffect>(LocationDetailState()) { state ->
        if (state.locationDetail == null) {
            getLocationDetail(id)
        }
    }

    private fun getLocationDetail(id: String) = intent {
        val response = getLocationDetailUseCase(id)
        reduce {
            state.copy(locationDetail = response)
        }
        if (response.residents.isNotEmpty()) {
            val responseResident = getCharacterListUseCase(response.residents)
            reduce {
                state.copy(residentList = responseResident)
            }
        }
    }
}


