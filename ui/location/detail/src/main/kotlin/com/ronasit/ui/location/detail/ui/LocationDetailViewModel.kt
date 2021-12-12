package com.ronasit.ui.location.detail.ui

import androidx.lifecycle.ViewModel
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailRepository
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailResidentRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container


class LocationDetailViewModel(
    private val locationDetailRepository: LocationDetailRepository,
    private val locationDetailResidentRepository: LocationDetailResidentRepository
) : ViewModel(), ContainerHost<LocationDetailState, LocationDetailSideEffect> {
    override val container = container<LocationDetailState, LocationDetailSideEffect>(LocationDetailState())

    fun getLocationDetail(id: Int) = intent {
        val response = locationDetailRepository.getLocationById(id)
        reduce {
            state.copy(locationDetail = response)
        }
        if (response.residents.isNotEmpty()) {
            val responseResident = locationDetailResidentRepository.getResidentsById(response.residents)
            reduce {
                state.copy(residentList = responseResident)
            }
        }
    }
}


