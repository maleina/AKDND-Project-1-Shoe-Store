package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.ShoeStoreViewModel
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = this.findNavController(R.id.myNavHostFragment)

        // Need this to display options menu in toolbar
        setSupportActionBar(toolbar)

        // Set up the navigation bar using top level fragements to remove the back button from
        // both login and the shoe list fragments
        val topLevelFragments = setOf(R.id.loginFragment, R.id.shoeListFragment)
        appBarConfiguration = AppBarConfiguration(topLevelFragments)
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        Timber.plant(Timber.DebugTree())
    }
}
