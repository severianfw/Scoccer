package com.severianfw.scoccer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severianfw.scoccer.data.ApiConfig
import com.severianfw.scoccer.data.model.topscorer.TopScorerUiModel
import com.severianfw.scoccer.data.model.topscorer.TopScorersResponseItem
import com.severianfw.scoccer.util.ResponseMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopScorersViewModel : ViewModel() {

  companion object {
    const val API_KEY = "b677ddf54ec8519ce006a0b6016cc0cf66100819b6c8a6399d4ef2b6765e0ff6"
  }

  private val apiConfig = ApiConfig()

  private val _isLoading = MutableLiveData<Boolean>()
  val isLoading: LiveData<Boolean>
    get() = _isLoading

  private val _topScorers = MutableLiveData<List<TopScorerUiModel>>()
  val topScorers: LiveData<List<TopScorerUiModel>>
    get() = _topScorers

  fun getTopScorers() {
    val leagueId = "148"

    val client = apiConfig.apiService.getTopScorers(API_KEY, leagueId)

    _isLoading.value = true
    client.enqueue(object : Callback<List<TopScorersResponseItem>> {
      override fun onResponse(
        call: Call<List<TopScorersResponseItem>>, response: Response<List<TopScorersResponseItem>>
      ) {
        if (response.isSuccessful) {
          response.body()?.let {
            _topScorers.value = ResponseMapper.mapTopScorerResponsesToTopScorersUiModels(it)
          }
        }
        _isLoading.value = false
      }

      override fun onFailure(call: Call<List<TopScorersResponseItem>>, t: Throwable) {
        _isLoading.value = false
      }

    })
  }
}