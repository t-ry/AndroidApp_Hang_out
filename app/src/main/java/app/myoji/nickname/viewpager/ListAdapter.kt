package app.myoji.nickname.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter: RecyclerView.Adapter<ListAdapter.gameViewHolder>() {

    private var gameList = emptyList<GameInfo>()

    class gameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)
        return gameViewHolder(view)
    }

    override fun getItemCount() = gameList.size

    override fun onBindViewHolder(holder: gameViewHolder, position: Int) {
        val currentItem = gameList[position]
        holder.textView.text = currentItem.GameTitle.toString()
    }

    fun setData(game: List<GameInfo>) {
        this.gameList = game
        notifyDataSetChanged()
    }

}
