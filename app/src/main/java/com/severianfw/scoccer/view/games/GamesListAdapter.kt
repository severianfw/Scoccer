package com.severianfw.scoccer.view.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.severianfw.scoccer.data.model.games.GamesUiModel
import com.severianfw.scoccer.databinding.ItemGamesBinding

class GamesListAdapter(private val games: List<GamesUiModel>) : RecyclerView.Adapter<GamesListAdapter.ViewHolder>() {

  inner class ViewHolder(private val viewBinding: ItemGamesBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

      fun bind(item: GamesUiModel) {
        viewBinding.apply {
          tvHomeClub.text = item.homeTeamName
          tvHomeScore.text = item.homeTeamScore
          Glide.with(viewBinding.root)
            .load(item.homeTeamImage)
            .into(ivHomeClub)

          tvAwayClub.text = item.awayTeamName
          tvAwayScore.text = item.awayTeamScore
          Glide.with(viewBinding.root)
            .load(item.awayTeamImage)
            .into(ivAwayClub)

          tvMatchStatus.text = item.matchStatus
        }
      }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val viewBinding = ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(viewBinding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(games[position])
  }

  override fun getItemCount(): Int = games.size


}