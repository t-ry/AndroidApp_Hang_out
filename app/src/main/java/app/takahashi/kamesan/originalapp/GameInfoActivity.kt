package app.takahashi.kamesan.originalapp

import android.os.Bundle
import android.text.util.Linkify
import android.view.MotionEvent
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
        binding.requiredTime.text = game?.requiredTime.toString() + "分"
        if (game?.url != null) {
            binding.url.text = game.url
            binding.url.autoLinkMask = Linkify.ALL
        }
        binding.playTime.text = "プレイ回数 : " + game?.experience.toString()

        if(game?.favorite == 1) binding.imageButton2.setImageResource(R.drawable.baseline_favorite_24)
        else binding.imageButton2.setImageResource(R.drawable.baseline_favorite_border_24)

        binding.imageButton2.setOnClickListener{
            if(game?.favorite == 1) {
                game?.favorite = 0
                binding.imageButton2.setImageResource(R.drawable.baseline_favorite_border_24)
            }else{
                game?.favorite = 1
                binding.imageButton2.setImageResource(R.drawable.baseline_favorite_24)
            }
        }

    }

}