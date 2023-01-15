package com.severianfw.scoccer.view.standings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.severianfw.scoccer.data.model.standings.StandingsUiModel
import com.severianfw.scoccer.databinding.ItemStandingsBinding

class StandingsListAdapter(private val standings: List<StandingsUiModel>) :
  RecyclerView.Adapter<StandingsListAdapter.ViewHolder>() {

  inner class ViewHolder(private val viewBinding: ItemStandingsBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: StandingsUiModel) {
      viewBinding.apply {
        tvClubName.text = item.clubName
        Glide.with(viewBinding.root).load(item.clubImage).into(ivClubLogo)

        tvPositionNumber.text = item.positionNumber
        tvMp.text = item.mp
        tvW.text = item.w
        tvD.text = item.d
        tvL.text = item.l
        tvGf.text = item.gf
        tvGa.text = item.ga
        tvGd.text = item.gd
        tvPts.text = item.pts
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val viewBinding =
      ItemStandingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(viewBinding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(standings[position])
  }

  override fun getItemCount(): Int {
    return standings.size
  }
}