package com.severianfw.scoccer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severianfw.scoccer.data.ApiConfig
import com.severianfw.scoccer.data.model.standings.StandingsResponseItem
import com.severianfw.scoccer.data.model.standings.StandingsUiModel
import com.severianfw.scoccer.util.ResponseMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StandingsViewModel : ViewModel() {

  companion object {
    const val API_KEY = "b677ddf54ec8519ce006a0b6016cc0cf66100819b6c8a6399d4ef2b6765e0ff6"
  }

  private val apiConfig = ApiConfig()

  private val _isLoading = MutableLiveData<Boolean>()
  val isLoading: LiveData<Boolean>
    get() = _isLoading

  private val _standings = MutableLiveData<List<StandingsUiModel>>()
  val standings: LiveData<List<StandingsUiModel>>
    get() = _standings

  fun getStandings() {
    val leagueId = "148"

    val client = apiConfig.apiService.getStandings(API_KEY, leagueId)

    _isLoading.value = true
    client.enqueue(object : Callback<List<StandingsResponseItem>> {
      override fun onResponse(
        call: Call<List<StandingsResponseItem>>, response: Response<List<StandingsResponseItem>>
      ) {
        if (response.isSuccessful) {
          response.body()?.let {
            _standings.value = ResponseMapper.mapStandingsResponsesToStandingsUiModels(it)
          }
        }
        _isLoading.value = false
      }

      override fun onFailure(call: Call<List<StandingsResponseItem>>, t: Throwable) {
        _isLoading.value = false
      }

    })

  }
}