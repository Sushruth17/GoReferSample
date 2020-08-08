package com.example.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var bottomNavigationView : BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        bottomNavigationView = findViewById(R.id.bttm_nav)
        val navHostFragment: NavHostFragment? = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        if (navHostFragment != null) {
            if (bottomNavigationView != null) {
                NavigationUI.setupWithNavController(
                    bottomNavigationView!!,
                    navHostFragment.navController)
            }
        }
    }
}