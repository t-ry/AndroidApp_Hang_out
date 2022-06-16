package app.takahashi.kamesan.originalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.takahashi.kamesan.originalapp.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchResultBinding
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private val easy = mutableListOf(1, 2, 3)
    private val difficult = mutableListOf(3, 4, 5)

    private val difficulty = mutableListOf<Int>()
    private val kinds = mutableListOf<Int>()
    private val favorite = mutableListOf<Int>()

    private val gameDb by lazy {
        GameDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        val recyclerView = binding.rvList
        val adapter = ListAdapter()
        recyclerView.adapter = adapter

        val playerNumber =
            when (intent.getIntExtra("player", 0)) {
                0 -> 1
                1 -> 2
                2 -> 3
                3 -> 4
                else -> 5
            }
        val requiredTime =
            when (intent.getIntExtra("time", 0)) {
                0 -> 30
                1 -> 60
                else -> 90
            }

        if (intent.getBooleanExtra("easy",false)) difficulty.addAll(easy)
        if (intent.getBooleanExtra("difficult", false)) difficulty.addAll(difficult)


        if (intent.getBooleanExtra("playingcard", false)) kinds.add(0)
        if (intent.getBooleanExtra("boardgames", false)) kinds.add(1)
        if (intent.getBooleanExtra("online", false)) kinds.add(2)

        if (intent.getIntExtra("favorite", 0) == 0) favorite.add(0)
        favorite.add(1)

        adapter.setData(
            gameDb?.gameDao()?.searchGame(difficulty, kinds, favorite, playerNumber, requiredTime)
                ?: listOf()
        )

        binding.textView5.text = "検索結果一覧 : " + adapter.itemCount.toString() + "件"

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter.itemClickListener = object : ListAdapter.OnItemClickListener {
            override fun onItemClick(gameId: Int) {
                val intentGameInfo = Intent(this@SearchResultActivity, GameInfoActivity::class.java)
                intentGameInfo.putExtra("gameId", gameId)
                startActivity(intentGameInfo)
            }
        }
    }
}