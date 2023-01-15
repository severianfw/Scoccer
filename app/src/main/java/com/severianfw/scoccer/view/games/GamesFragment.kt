package com.severianfw.scoccer.view.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.severianfw.scoccer.databinding.FragmentGamesBinding

class GamesFragment : Fragment() {

  private var _viewBinding: FragmentGamesBinding? = null
  private val viewBinding get() = _viewBinding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View { // Inflate the layout for this fragment
    _viewBinding = FragmentGamesBinding.inflate(layoutInflater, container, false)
    return viewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val viewPager = viewBinding.viewPager
    viewPager.adapter = GamesTabAdapter(parentFragmentManager)
    viewBinding.tabGames.setupWithViewPager(viewPager)
  }
}