package com.severianfw.scoccer.data.model.games

import com.google.gson.annotations.SerializedName

data class GamesResponse(

	@field:SerializedName("GamesResponse")
	val gamesResponse: List<GamesResponseItem>? = null
)

data class CardsItem(

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("home_fault")
	val homeFault: String? = null,

	@field:SerializedName("card")
	val card: String? = null,

	@field:SerializedName("away_fault")
	val awayFault: String? = null,

	@field:SerializedName("info")
	val info: String? = null
)

data class GamesResponseItem(

	@field:SerializedName("cards")
	val cards: List<CardsItem?>? = null,

	@field:SerializedName("match_awayteam_name")
	val matchAwayteamName: String? = null,

	@field:SerializedName("match_awayteam_ft_score")
	val matchAwayteamFtScore: String? = null,

	@field:SerializedName("league_logo")
	val leagueLogo: String? = null,

	@field:SerializedName("match_hometeam_halftime_score")
	val matchHometeamHalftimeScore: String? = null,

	@field:SerializedName("lineup")
	val lineup: Lineup? = null,

	@field:SerializedName("match_referee")
	val matchReferee: String? = null,

	@field:SerializedName("match_awayteam_halftime_score")
	val matchAwayteamHalftimeScore: String? = null,

	@field:SerializedName("match_date")
	val matchDate: String? = null,

	@field:SerializedName("match_hometeam_system")
	val matchHometeamSystem: String? = null,

	@field:SerializedName("match_live")
	val matchLive: String? = null,

	@field:SerializedName("match_awayteam_score")
	val matchAwayteamScore: String? = null,

	@field:SerializedName("substitutions")
	val substitutions: Substitutions? = null,

	@field:SerializedName("country_name")
	val countryName: String? = null,

	@field:SerializedName("match_awayteam_id")
	val matchAwayteamId: String? = null,

	@field:SerializedName("match_hometeam_extra_score")
	val matchHometeamExtraScore: String? = null,

	@field:SerializedName("team_home_badge")
	val teamHomeBadge: String? = null,

	@field:SerializedName("match_stadium")
	val matchStadium: String? = null,

	@field:SerializedName("match_awayteam_penalty_score")
	val matchAwayteamPenaltyScore: String? = null,

	@field:SerializedName("match_hometeam_ft_score")
	val matchHometeamFtScore: String? = null,

	@field:SerializedName("goalscorer")
	val goalscorer: List<GoalscorerItem?>? = null,

	@field:SerializedName("match_hometeam_id")
	val matchHometeamId: String? = null,

	@field:SerializedName("match_id")
	val matchId: String? = null,

	@field:SerializedName("league_name")
	val leagueName: String? = null,

	@field:SerializedName("match_time")
	val matchTime: String? = null,

	@field:SerializedName("match_awayteam_system")
	val matchAwayteamSystem: String? = null,

	@field:SerializedName("match_status")
	val matchStatus: String? = null,

	@field:SerializedName("match_hometeam_score")
	val matchHometeamScore: String? = null,

	@field:SerializedName("match_awayteam_extra_score")
	val matchAwayteamExtraScore: String? = null,

	@field:SerializedName("match_hometeam_name")
	val matchHometeamName: String? = null,

	@field:SerializedName("match_hometeam_penalty_score")
	val matchHometeamPenaltyScore: String? = null,

	@field:SerializedName("match_round")
	val matchRound: String? = null,

	@field:SerializedName("country_id")
	val countryId: String? = null,

	@field:SerializedName("league_id")
	val leagueId: String? = null,

	@field:SerializedName("team_away_badge")
	val teamAwayBadge: String? = null,

	@field:SerializedName("country_logo")
	val countryLogo: String? = null,

	@field:SerializedName("statistics")
	val statistics: List<StatisticsItem?>? = null
)

data class Substitutions(

	@field:SerializedName("away")
	val away: List<AwayItem?>? = null,

	@field:SerializedName("home")
	val home: List<HomeItem?>? = null
)

data class GoalscorerItem(

	@field:SerializedName("score")
	val score: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("away_scorer")
	val awayScorer: String? = null,

	@field:SerializedName("home_scorer")
	val homeScorer: String? = null,

	@field:SerializedName("info")
	val info: String? = null
)

data class CoachItem(

	@field:SerializedName("lineup_position")
	val lineupPosition: String? = null,

	@field:SerializedName("lineup_player")
	val lineupPlayer: String? = null,

	@field:SerializedName("lineup_number")
	val lineupNumber: String? = null
)

data class AwayItem(

	@field:SerializedName("substitution")
	val substitution: String? = null,

	@field:SerializedName("time")
	val time: String? = null
)

data class Lineup(

	@field:SerializedName("away")
	val away: Away? = null,

	@field:SerializedName("home")
	val home: Home? = null
)

data class SubstitutesItem(

	@field:SerializedName("lineup_position")
	val lineupPosition: String? = null,

	@field:SerializedName("lineup_player")
	val lineupPlayer: String? = null,

	@field:SerializedName("lineup_number")
	val lineupNumber: String? = null
)

data class MissingPlayersItem(

	@field:SerializedName("lineup_position")
	val lineupPosition: String? = null,

	@field:SerializedName("lineup_player")
	val lineupPlayer: String? = null,

	@field:SerializedName("lineup_number")
	val lineupNumber: String? = null
)

data class Away(

	@field:SerializedName("starting_lineups")
	val startingLineups: List<StartingLineupsItem?>? = null,

	@field:SerializedName("substitutes")
	val substitutes: List<SubstitutesItem?>? = null,

	@field:SerializedName("coach")
	val coach: List<CoachItem?>? = null,

	@field:SerializedName("missing_players")
	val missingPlayers: List<MissingPlayersItem?>? = null
)

data class HomeItem(

	@field:SerializedName("substitution")
	val substitution: String? = null,

	@field:SerializedName("time")
	val time: String? = null
)

data class StartingLineupsItem(

	@field:SerializedName("lineup_position")
	val lineupPosition: String? = null,

	@field:SerializedName("lineup_player")
	val lineupPlayer: String? = null,

	@field:SerializedName("lineup_number")
	val lineupNumber: String? = null
)

data class StatisticsItem(

	@field:SerializedName("away")
	val away: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("home")
	val home: String? = null
)

data class Home(

	@field:SerializedName("starting_lineups")
	val startingLineups: List<StartingLineupsItem?>? = null,

	@field:SerializedName("substitutes")
	val substitutes: List<SubstitutesItem?>? = null,

	@field:SerializedName("coach")
	val coach: List<CoachItem?>? = null,

	@field:SerializedName("missing_players")
	val missingPlayers: List<MissingPlayersItem?>? = null
)
