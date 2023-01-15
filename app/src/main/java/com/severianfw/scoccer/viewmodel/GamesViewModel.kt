package com.severianfw.scoccer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severianfw.scoccer.data.ApiConfig
import com.severianfw.scoccer.data.model.games.GamesResponseItem
import com.severianfw.scoccer.data.model.games.GamesUiModel
import com.severianfw.scoccer.util.ResponseMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class GamesViewModel : ViewModel() {

  companion object {
    const val API_KEY = "b677ddf54ec8519ce006a0b6016cc0cf66100819b6c8a6399d4ef2b6765e0ff6"
  }

  private val apiConfig = ApiConfig()

  private val _games = MutableLiveData<List<GamesUiModel>>()
  val games: LiveData<List<GamesUiModel>>
    get() = _games

  private val _isLoading = MutableLiveData<Boolean>()
  val isLoading: LiveData<Boolean>
    get() = _isLoading

  fun getGames(gamesDate: GamesDate) {
    val leagueId = "148"
    val dateFrom = getFormattedDate(gamesDate)
    val dateTo = getFormattedDate(gamesDate)
    val timeZone = "Asia/Jakarta"

    val client = apiConfig.apiService.getGames(API_KEY, leagueId, dateFrom, dateTo, timeZone)

    _isLoading.value = true
    client.enqueue(object : Callback<List<GamesResponseItem>> {
      override fun onResponse(call: Call<List<GamesResponseItem>>, response: Response<List<GamesResponseItem>>) {
        if (response.isSuccessful) {
          response.body()?.let {
            _games.value = ResponseMapper.mapGamesResponsesToGamesUiModels(it)
          }
        }
        _isLoading.value = false
      }

      override fun onFailure(call: Call<List<GamesResponseItem>>, t: Throwable) {
        _isLoading.value = false
      }
    })
  }

  private fun getFormattedDate(gamesDate: GamesDate): String {
    val calendar = Calendar.getInstance()

    when (gamesDate) {
      GamesDate.Today -> calendar.add(Calendar.DATE, 0)
      GamesDate.Tomorrow -> calendar.add(Calendar.DATE, 1)
      GamesDate.Yesterday -> calendar.add(Calendar.DATE, -1)
    }

    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("id"))
    return formatter.format(calendar.time)
  }
}

enum class GamesDate {
  Today, Yesterday, Tomorrow
}