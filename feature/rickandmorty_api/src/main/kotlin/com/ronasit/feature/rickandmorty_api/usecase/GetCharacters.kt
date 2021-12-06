package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.models.Character
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import timber.log.Timber

class GetCharacters(
    private val characterRepository:CharacterRepository
) {

    suspend operator fun invoke(page:Int):List<Character>{
        Timber.i("interceptor")
        return characterRepository.getCharacters(page)
    }


    /*operator fun invoke(): Flow<DataState<List<Character>>> = flow{

        emit(DataState.Loading)
        try{
            val characters = characterRepository.getTestCharacters()

            emit(DataState.Success(characters))
        } catch (e:Exception){
            emit(DataState.Error(e))
        }
    }*/
}
