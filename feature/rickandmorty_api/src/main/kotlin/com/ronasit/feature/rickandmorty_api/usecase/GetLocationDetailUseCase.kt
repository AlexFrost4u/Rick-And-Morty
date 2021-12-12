package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailRepository

class GetLocationDetailUseCase(
    private val locationDetailRepository: LocationDetailRepository
) {
    suspend operator fun invoke(id: Int): LocationDetail {
        return locationDetailRepository.getLocationById(id)
    }
}
