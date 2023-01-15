package com.severianfw.scoccer.view

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import android.view.MenuItem
import com.severianfw.scoccer.R
import com.severianfw.scoccer.databinding.ActivityMainBinding
import com.severianfw.scoccer.view.games.GamesFragment
import com.severianfw.scoccer.view.standings.StandingsFragment
import com.severianfw.scoccer.view.topscorers.TopScorersFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

  private var _viewBinding: ActivityMainBinding? = null
  private val viewBinding get() = _viewBinding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _viewBinding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewBinding.bottomNav.setOnNavigationItemSelectedListener(this)
    supportFragmentManager.beginTransaction()
      .replace(viewBinding.fragmentContainer.id, GamesFragment::class.java, null).commit()
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.menu_games -> {
        supportFragmentManager.beginTransaction()
          .replace(viewBinding.fragmentContainer.id, GamesFragment::class.java, null).commit()
      }
      R.id.menu_standings -> {
        supportFragmentManager.beginTransaction()
          .replace(viewBinding.fragmentContainer.id, StandingsFragment::class.java, null).commit()
      }
      R.id.menu_top_scorer -> {
        supportFragmentManager.beginTransaction()
          .replace(viewBinding.fragmentContainer.id, TopScorersFragment::class.java, null).commit()
      }
    }
    return true
  }
}