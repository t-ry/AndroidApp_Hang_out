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

        val recyclerView = binding.rvList
        val adapter = ListAdapter()
        recyclerView.adapter = adapter
        //adapter.setData(gameDb?.gameDao()?.)
    }
}