package com.severianfw.scoccer.view.topscorers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.severianfw.scoccer.data.model.topscorer.TopScorerUiModel
import com.severianfw.scoccer.databinding.ItemTopScorerBinding

class TopScorersListAdapter(private val topScorers: List<TopScorerUiModel>) :
  RecyclerView.Adapter<TopScorersListAdapter.ViewHolder>() {

  inner class ViewHolder(private val viewBinding: ItemTopScorerBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: TopScorerUiModel, position: Int) {
      viewBinding.apply {
        tvPlayerName.text = item.playerName
        tvClubName.text = item.clubName
        tvGoals.text = item.goals
        tvPositionNumber.text = "${position.plus(1)}"
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val viewBinding =
      ItemTopScorerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(viewBinding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(topScorers[position], position)
  }

  override fun getItemCount(): Int {
    return topScorers.size
  }
}