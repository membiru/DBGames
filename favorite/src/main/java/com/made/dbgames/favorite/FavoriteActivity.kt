package com.made.dbgames.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.made.dbgames.R
import com.made.dbgames.core.ui.GamesAdapter
import com.made.dbgames.detail.DetailActivity
import com.made.dbgames.favorite.databinding.ActivityFavoriteListBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private lateinit var binding: ActivityFavoriteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        supportActionBar?.title = getString(R.string.menu_favorite)
        getGameData()
    }

    private fun getGameData() {
        val gamesAdapter = GamesAdapter()
        gamesAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteGame.observe(this, {data ->
            gamesAdapter.setData(data)
            binding.viewEmpty.visibility = if (data.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvGame) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = gamesAdapter
        }
    }
}