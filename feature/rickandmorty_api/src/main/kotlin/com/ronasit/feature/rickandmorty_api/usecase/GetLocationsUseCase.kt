package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.LocationPager
import com.ronasit.feature.rickandmorty_api.repository.LocationRepository

class GetLocationsUseCase(
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(page: Int, name: String, type: String, dimension: String): LocationPager {
        return locationRepository.getLocations(page, name, type, dimension)
    }
}
