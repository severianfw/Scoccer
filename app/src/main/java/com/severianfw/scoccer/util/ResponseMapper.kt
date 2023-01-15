package com.severianfw.scoccer.util

import com.severianfw.scoccer.data.model.games.GamesResponseItem
import com.severianfw.scoccer.data.model.games.GamesUiModel
import com.severianfw.scoccer.data.model.standings.StandingsResponseItem
import com.severianfw.scoccer.data.model.standings.StandingsUiModel
import com.severianfw.scoccer.data.model.topscorer.TopScorerUiModel
import com.severianfw.scoccer.data.model.topscorer.TopScorersResponseItem

object ResponseMapper {

  fun mapGamesResponsesToGamesUiModels(responseList: List<GamesResponseItem>): List<GamesUiModel> {
    return responseList.map {
      GamesUiModel(
        homeTeamName = it.matchHometeamName,
        homeTeamImage = it.teamHomeBadge,
        homeTeamScore = it.matchHometeamScore,
        awayTeamName = it.matchAwayteamName,
        awayTeamImage = it.teamAwayBadge,
        awayTeamScore = it.matchAwayteamScore,
        matchStatus = if (it.matchStatus == "Finished") {
          "FT"
        } else {
          it.matchTime
        }
      )
    }.toList()
  }

  fun mapStandingsResponsesToStandingsUiModels(responseList: List<StandingsResponseItem>): List<StandingsUiModel> {
    return responseList.map {
      StandingsUiModel(
        clubImage = it.teamBadge,
        clubName = it.teamName,
        mp = it.overallLeaguePayed,
        w = it.overallLeagueW,
        d = it.overallLeagueD,
        l = it.overallLeagueL,
        gf = it.overallLeagueGF,
        ga = it.overallLeagueGA,
        gd = getGF(it.overallLeagueGF, it.overallLeagueGA),
        pts = it.overallLeaguePTS,
        positionNumber = it.overallLeaguePosition
      )
    }.toList()
  }

  private fun getGF(gfString: String?, gaString: String?): String {
    return if (gfString.isNullOrBlank().not() && gaString.isNullOrBlank().not()) {
      val gf = gfString?.toInt()
      val ga = gaString?.toInt()
      val result = gf?.minus(ga ?: 0)
      result.toString()
    } else {
      ""
    }
  }

  fun mapTopScorerResponsesToTopScorersUiModels(responseList: List<TopScorersResponseItem>): List<TopScorerUiModel> {
    return responseList.map {
      TopScorerUiModel(
        playerName = it.playerName,
        clubName = it.teamName,
        goals = it.goals,
        placeNumber = it.playerPlace
      )
    }.toList()
  }
}