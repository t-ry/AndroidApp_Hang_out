package app.myoji.nickname.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.myoji.nickname.viewpager.databinding.FragmentFavoriteBinding

class favoriteFragment : Fragment(R.layout.fragment_favorite){

    private lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var db: GameDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteBinding.bind(view)

        layoutManager = LinearLayoutManager(this.requireContext())

        db = GameDatabase.getDatabase(this.requireContext())!!

        val recyclerview = binding.rvList
        val adapter = ListAdapter()
        recyclerview.adapter = adapter

        val layoutManager = LinearLayoutManager(this.requireContext())
        recyclerview.layoutManager = layoutManager
    }
}

