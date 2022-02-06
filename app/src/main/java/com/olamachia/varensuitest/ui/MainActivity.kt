package com.olamachia.varensuitest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.olamachia.varensuitest.utils.checkMenuItem
import olamachia.varensuitest.R
import olamachia.varensuitest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.apply {
            bottomNavView.setupWithNavController(navController)

            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                if (destination.id == R.id.exchangeFragment) {
                    bottomNavView.isVisible = false
                } else {
                    bottomNavView.isVisible = true
                    bottomNavView.checkMenuItem(destination.id)
                }
            }
        }

    }
}