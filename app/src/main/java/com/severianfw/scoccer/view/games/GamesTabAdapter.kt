package com.severianfw.scoccer.view.games

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class GamesTabAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
  override fun getCount(): Int {
    return 2
  }

  override fun getItem(position: Int): Fragment {
    val fragment = when (position) {
      0 -> {
        GamesTabFragment.newInstance("Today")
      }
      1 -> {
        GamesTabFragment.newInstance("Tomorrow")
      }
      else -> {
        GamesTabFragment.newInstance("")
      }
    }
    return fragment
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return when (position) {
      0 -> {
        "Today"
      }
      1 -> {
        "Tomorrow"
      }
      else -> {
        ""
      }
    }
  }
}