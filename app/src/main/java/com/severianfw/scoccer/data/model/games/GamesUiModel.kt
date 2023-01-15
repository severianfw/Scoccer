package com.severianfw.scoccer.data.model.games

data class GamesUiModel(
  val homeTeamName: String? = null,
  val homeTeamImage: String? = null,
  val homeTeamScore: String? = null,
  val awayTeamName: String? = null,
  val awayTeamImage: String? = null,
  val awayTeamScore: String? = null,
  val matchStatus: String? = null,
)
