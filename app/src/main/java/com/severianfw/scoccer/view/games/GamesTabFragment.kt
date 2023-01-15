package com.severianfw.scoccer.view.games

import com.severianfw.scoccer.viewmodel.GamesViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.severianfw.scoccer.viewmodel.GamesDate
import com.severianfw.scoccer.data.model.games.GamesUiModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.severianfw.scoccer.databinding.FragmentGamesTabBinding

private const val ARG_TAB_TITLE = "title"

class GamesTabFragment : Fragment() {

  private val gamesViewModel = GamesViewModel()
  private var _viewBinding: FragmentGamesTabBinding? = null
  private val viewBinding get() = _viewBinding!!
  private var tabTitle: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      tabTitle = it.getString(ARG_TAB_TITLE)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    _viewBinding = FragmentGamesTabBinding.inflate(inflater, container, false)
    return viewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    getGames()
    gamesViewModel.games.observe(viewLifecycleOwner) { items ->
      setupRecyclerView(items)
    }
    gamesViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
      viewBinding.srlGames.isRefreshing = isLoading
    }
    viewBinding.srlGames.setOnRefreshListener {
      getGames()
    }
  }

  private fun getGames() {
    when (tabTitle) {
      "Today" -> gamesViewModel.getGames(GamesDate.Today)
      "Tomorrow" -> gamesViewModel.getGames(GamesDate.Tomorrow)
    }
  }

  private fun setupRecyclerView(items: List<GamesUiModel>) {
    if (context != null) {
      viewBinding.rvGames.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = GamesListAdapter(items)
      }
    }
  }

  companion object {
    fun newInstance(tabTitle: String): GamesTabFragment {
      return GamesTabFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_TAB_TITLE, tabTitle)
        }
      }
    }
  }
}