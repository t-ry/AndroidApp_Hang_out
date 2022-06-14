package app.takahashi.kamesan.originalapp

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import app.takahashi.kamesan.originalapp.databinding.ActivityGameInfoBinding

class GameInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameInfoBinding

    private val gameDb by lazy {
        GameDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameInfoBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        val gameId = intent.getIntExtra("gameId", 0)
        println(gameId.toString())
        val game = gameDb?.gameDao()?.getGameFromId(gameId)

        binding.textView.text = game?.gameTitle
        binding.gameRule.text = game?.gameRule
        binding.reqiredTime.text = game?.requiredTime.toString()
        if (game?.url != null) {
            binding.url.text = game.url
        }
    }
}