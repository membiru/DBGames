package com.made.dbgames.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.made.dbgames.R
import com.made.dbgames.core.domain.model.Game
import com.made.dbgames.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailGameViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailGame = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailGame(detailGame)
    }

    private fun showDetailGame(detailGame: Game?) {

        detailGame?.let {
            val stringRelease = resources.getString(R.string.released, detailGame.released)
            val stringRating = resources.getString(R.string.rating, detailGame.rating.toString())
            val stringRatingCount = resources.getString(R.string.rating_count, detailGame.ratingsCount.toString())

            supportActionBar?.title = detailGame.name
            binding.content.tvDetailReleased.text = stringRelease
            binding.content.tvDetailRating.text = stringRating
            binding.content.tvDetailRatingCount.text = stringRatingCount
            Glide.with(this@DetailActivity)
                .load(detailGame.backgroundImage)
                .into(binding.ivDetailImage)

            var statusFavorite = detailGame.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailGameViewModel.setFavoriteGame(detailGame, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
