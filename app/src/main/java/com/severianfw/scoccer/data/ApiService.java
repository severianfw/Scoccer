package com.severianfw.scoccer.data;

import com.severianfw.scoccer.data.model.games.GamesResponseItem;
import com.severianfw.scoccer.data.model.standings.StandingsResponseItem;
import com.severianfw.scoccer.data.model.topscorer.TopScorersResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String apiKey = "b677ddf54ec8519ce006a0b6016cc0cf66100819b6c8a6399d4ef2b6765e0ff6";

    @GET("?action=get_events")
    Call<List<GamesResponseItem>> getGames(
            @Query("APIkey") String apiKey,
            @Query("league_id") String leagueId,
            @Query("from") String dateFrom,
            @Query("to") String dateUntil,
            @Query("timezone") String timezone);

    @GET("?action=get_standings")
    Call<List<StandingsResponseItem>> getStandings(
            @Query("APIkey") String apiKey,
            @Query("league_id") String leagueId);

    @GET("?action=get_topscorers")
    Call<List<TopScorersResponseItem>> getTopScorers(
            @Query("APIkey") String apiKey,
            @Query("league_id") String leagueId);
}
