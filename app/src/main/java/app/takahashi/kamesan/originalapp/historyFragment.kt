package app.takahashi.kamesan.originalapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.takahashi.kamesan.originalapp.databinding.FragmentFavoriteBinding
import app.takahashi.kamesan.originalapp.databinding.FragmentHistoryBinding

class historyFragment: Fragment(R.layout.fragment_history) {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    val gameDb by lazy {
        GameDatabase.getDatabase(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHistoryBinding.bind(view)

        layoutManager = LinearLayoutManager(this.requireContext())

        val recyclerview = binding.rvList
        val adapter = ListAdapter()
        recyclerview.adapter = adapter
        adapter.setData(gameDb?.gameDao()?.getAll() ?: listOf())

        val layoutManager = LinearLayoutManager(this.requireContext())
        recyclerview.layoutManager = layoutManager


        adapter.itemClickListener = object :ListAdapter.OnItemClickListener {
            override fun onItemClick(gameId: Int) {
                val intent = Intent(requireActivity(),GameInfoActivity::class.java)
                intent.putExtra("gameId", gameId)
                startActivity(intent)
            }
        }
    }
}
