package app.takahashi.kamesan.originalapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when (position){
            0-> SearchFragment()
            1-> FavoriteFragment()
            2-> historyFragment()
            else -> throw IllegalAccessException()
        }
    }