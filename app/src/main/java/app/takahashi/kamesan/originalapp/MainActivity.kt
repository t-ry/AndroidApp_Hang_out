package app.takahashi.kamesan.originalapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import app.takahashi.kamesan.originalapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val gameDb by lazy { GameDatabase.getDatabase(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        val pref: SharedPreferences = getSharedPreferences("first_start_up", Context.MODE_PRIVATE)
        val cnt = pref.getBoolean("first_start_up", true)


        //初回起動
        //if(cnt){
            val initialList = initialGameInfo

            gameDb?.gameDao()?.deleteAll()

            initialList.forEach {
                gameDb?.gameDao()?.insert(it)
            }
            val editor = pref.edit()
            editor.putBoolean("first_start_up", false)
            editor.apply()
        //}

        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = resources.getStringArray(R.array.tabTitle)[position]
        }.attach()

        binding.searchPageButton.setOnClickListener { toSearchPage() }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when (position) {
                    0 -> binding.searchPageButton.hide()
                    else -> binding.searchPageButton.show()
                }

            }
        })
    }

    private fun toSearchPage() {
        binding.viewPager.currentItem = 0
    }
}