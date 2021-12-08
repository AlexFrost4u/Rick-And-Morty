package com.ronasit.feature.rickandmorty_api.use_cases

import com.ronasit.feature.rickandmorty_api.models.LocationPager
import com.ronasit.feature.rickandmorty_api.repository.LocationRepository

class GetLocations(
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(page: Int): LocationPager {
        return locationRepository.getLocations(page)
    }
}
