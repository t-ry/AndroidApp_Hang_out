package app.takahashi.kamesan.originalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import app.takahashi.kamesan.originalapp.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchResultBinding
    private lateinit var layoutManager: RecyclerView.LayoutManager

    val gameDb by lazy {
        GameDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        val playerNumber = when (intent.getIntExtra("player", 0)) {
            0 -> 1
            1 -> 2
            2 -> 3
            3 -> 4
            else -> 5
        }
        val requiredTime = when (intent.getIntExtra("time", 0)) {
            0 -> 30
            1 -> 60
            else -> 90
        }

        val recyclerView = binding.rvList
        val adapter = ListAdapter()
        recyclerView.adapter = adapter

        val gameDao = gameDb?.gameDao()

        val cardGameList =
            if (intent.getIntExtra("kinds", 0) == 1) gameDao?.getPlayingcardGame()
            else gameDao?.getAll()
        val boardgamesList =
            if(intent.getIntExtra("boardgames", 0) == 1) gameDao?.getBoardgamesGame()
            else gameDao?.getAll()
        val onlineGameList =
            if(intent.getIntExtra("online", 0) == 1) gameDao?.getOnlineGame()
            else gameDao?.getAll()

        val favGameList =
            if(intent.getIntExtra("favorite", 0) == 1) gameDao?.getGameFromFav()
            else gameDao?.getAll()

    }
}