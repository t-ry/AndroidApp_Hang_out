package app.takahashi.kamesan.originalapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import app.takahashi.kamesan.originalapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        val pref: SharedPreferences = getSharedPreferences("first_start_up",Context.MODE_PRIVATE)
        val cnt = pref.getInt("first_start_up",0)

        //初回起動
        if(cnt == 0){



            val editor = pref.edit()
            editor.putInt("first_start_up",1)
            editor.apply()
        }
        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = resources.getStringArray(R.array.tabTitle)[position]
        }.attach()

        binding.searchPageButton.setOnClickListener{ toSearchPage() }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when(position){
                    0 -> binding.searchPageButton.hide()
                    else -> binding.searchPageButton.show()
                    }

            }
        })
    }
    private fun toSearchPage(){
        binding.viewPager.currentItem = 0
    }
}