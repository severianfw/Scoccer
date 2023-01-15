package com.severianfw.scoccer.data.model.topscorer

import com.google.gson.annotations.SerializedName

data class TopScorersResponse(

	@field:SerializedName("TopScorersResponse")
	val topScorersResponse: List<TopScorersResponseItem?>? = null
)

data class TopScorersResponseItem(

	@field:SerializedName("player_name")
	val playerName: String? = null,

	@field:SerializedName("team_key")
	val teamKey: String? = null,

	@field:SerializedName("team_name")
	val teamName: String? = null,

	@field:SerializedName("player_place")
	val playerPlace: String? = null,

	@field:SerializedName("goals")
	val goals: String? = null
)
