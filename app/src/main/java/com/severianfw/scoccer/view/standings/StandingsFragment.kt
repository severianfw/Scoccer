package com.severianfw.scoccer.view.standings

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.severianfw.scoccer.data.model.standings.StandingsUiModel
import com.severianfw.scoccer.databinding.FragmentStandingsBinding
import com.severianfw.scoccer.viewmodel.StandingsViewModel

class StandingsFragment : Fragment() {

  private var _viewBinding: FragmentStandingsBinding? = null
  private val viewBinding get() = _viewBinding!!
  private val viewModel = StandingsViewModel()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View { // Inflate the layout for this fragment
    _viewBinding = FragmentStandingsBinding.inflate(inflater, container, false)
    return viewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setLeagueLogo()
    viewModel.getStandings()

    viewModel.standings.observe(viewLifecycleOwner) {
      setupRecyclerView(it)
    }
    viewModel.isLoading.observe(viewLifecycleOwner) {
      viewBinding.srlStandings.isRefreshing = it
    }
    viewBinding.srlStandings.setOnRefreshListener {
      viewModel.getStandings()
    }
  }

  private fun setupRecyclerView(items: List<StandingsUiModel>) {
    context?.let { safeContext ->
      viewBinding.rvStandings.apply {
        layoutManager = LinearLayoutManager(safeContext)
        adapter = StandingsListAdapter(items)
      }
    }
  }

  private fun setLeagueLogo() {
    activity?.let {
      Glide.with(it)
        .load("https://apiv2.apifootball.com/badges/logo_leagues/148_premier-league.png")
        .into(viewBinding.ivLeagueLogo)
    }
  }
}