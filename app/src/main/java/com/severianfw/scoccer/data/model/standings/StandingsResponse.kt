package com.severianfw.scoccer.data.model.standings

import com.google.gson.annotations.SerializedName

data class StandingsResponse(

	@field:SerializedName("StandingsResponse")
	val standingsResponse: List<StandingsResponseItem>? = null
)

data class StandingsResponseItem(

	@field:SerializedName("away_league_W")
	val awayLeagueW: String? = null,

	@field:SerializedName("overall_league_D")
	val overallLeagueD: String? = null,

	@field:SerializedName("home_league_PTS")
	val homeLeaguePTS: String? = null,

	@field:SerializedName("overall_league_payed")
	val overallLeaguePayed: String? = null,

	@field:SerializedName("overall_league_L")
	val overallLeagueL: String? = null,

	@field:SerializedName("team_id")
	val teamId: String? = null,

	@field:SerializedName("team_badge")
	val teamBadge: String? = null,

	@field:SerializedName("home_league_GF")
	val homeLeagueGF: String? = null,

	@field:SerializedName("home_league_position")
	val homeLeaguePosition: String? = null,

	@field:SerializedName("away_league_L")
	val awayLeagueL: String? = null,

	@field:SerializedName("away_league_payed")
	val awayLeaguePayed: String? = null,

	@field:SerializedName("home_league_GA")
	val homeLeagueGA: String? = null,

	@field:SerializedName("country_name")
	val countryName: String? = null,

	@field:SerializedName("overall_promotion")
	val overallPromotion: String? = null,

	@field:SerializedName("overall_league_GA")
	val overallLeagueGA: String? = null,

	@field:SerializedName("overall_league_position")
	val overallLeaguePosition: String? = null,

	@field:SerializedName("home_league_W")
	val homeLeagueW: String? = null,

	@field:SerializedName("overall_league_GF")
	val overallLeagueGF: String? = null,

	@field:SerializedName("away_league_D")
	val awayLeagueD: String? = null,

	@field:SerializedName("overall_league_W")
	val overallLeagueW: String? = null,

	@field:SerializedName("home_league_payed")
	val homeLeaguePayed: String? = null,

	@field:SerializedName("home_league_L")
	val homeLeagueL: String? = null,

	@field:SerializedName("league_round")
	val leagueRound: String? = null,

	@field:SerializedName("away_promotion")
	val awayPromotion: String? = null,

	@field:SerializedName("home_promotion")
	val homePromotion: String? = null,

	@field:SerializedName("league_name")
	val leagueName: String? = null,

	@field:SerializedName("home_league_D")
	val homeLeagueD: String? = null,

	@field:SerializedName("team_name")
	val teamName: String? = null,

	@field:SerializedName("overall_league_PTS")
	val overallLeaguePTS: String? = null,

	@field:SerializedName("away_league_GF")
	val awayLeagueGF: String? = null,

	@field:SerializedName("away_league_GA")
	val awayLeagueGA: String? = null,

	@field:SerializedName("away_league_position")
	val awayLeaguePosition: String? = null,

	@field:SerializedName("away_league_PTS")
	val awayLeaguePTS: String? = null,

	@field:SerializedName("league_id")
	val leagueId: String? = null
)
