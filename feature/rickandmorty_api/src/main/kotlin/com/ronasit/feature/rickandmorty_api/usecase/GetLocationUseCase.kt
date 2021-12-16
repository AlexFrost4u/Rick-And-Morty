package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import com.ronasit.feature.rickandmorty_api.repository.LocationRepository

class GetLocationUseCase(
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(id: String): LocationDetail {
        return locationRepository.getLocation(id)
    }
}
