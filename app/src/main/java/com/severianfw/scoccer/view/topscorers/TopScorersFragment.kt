package com.severianfw.scoccer.view.topscorers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.severianfw.scoccer.data.model.topscorer.TopScorerUiModel
import com.severianfw.scoccer.databinding.FragmentTopScorersBinding
import com.severianfw.scoccer.viewmodel.TopScorersViewModel

class TopScorersFragment : Fragment() {

  private var _viewBinding: FragmentTopScorersBinding? = null
  private val viewBinding get() = _viewBinding!!
  private val viewModel = TopScorersViewModel()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View { // Inflate the layout for this fragment
    _viewBinding = FragmentTopScorersBinding.inflate(inflater, container, false)
    return viewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setLeagueLogo()

    viewModel.getTopScorers()
    viewModel.topScorers.observe(viewLifecycleOwner) {
      setupRecyclerView(it)
    }
    viewModel.isLoading.observe(viewLifecycleOwner) {
      viewBinding.srlTopScorers.isRefreshing = it
    }
    viewBinding.srlTopScorers.setOnRefreshListener {
      viewModel.getTopScorers()
    }
  }

  private fun setLeagueLogo() {
    activity?.let {
      Glide.with(it)
        .load("https://apiv2.apifootball.com/badges/logo_leagues/148_premier-league.png")
        .into(viewBinding.ivLeagueLogo)
    }
  }

  private fun setupRecyclerView(items: List<TopScorerUiModel>) {
    context?.let { safeContext ->
      viewBinding.rvStandings.apply {
        layoutManager = LinearLayoutManager(safeContext)
        adapter = TopScorersListAdapter(items)
      }
    }
  }
}