package app.takahashi.kamesan.originalapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.takahashi.kamesan.originalapp.databinding.FragmentFavoriteBinding

class historyFragment: Fragment(R.layout.fragment_history){

    lateinit var db: GameDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteBinding.bind(view)

        db = GameDatabase.getDatabase(this.requireContext())!!

        val recyclerview = binding.rvList
        val adapter = ListAdapter()
        recyclerview.adapter = adapter

        val layoutManager = LinearLayoutManager(this.requireContext())
        recyclerview.layoutManager = layoutManager
    }

}
