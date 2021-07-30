package com.peculiaruc.tourdeglob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController

    //to use BottomNavigation, here remove this 2 and add BottomNavigation
    //Private lateint var bottomNavigation : BottomNavigation

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.activity_main_toolbar)
        // call bottomNavigation here
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)


        //get navHostfragment and navController
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFrag.navController

        //set up appBarcongi and connect other views to it.
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout) //remove drawerLayout here if using BottomNavigation

        toolbar.setupWithNavController(navController, appBarConfiguration)
        //for BottomNavigation change navigationView to bottomNavigation
        navigationView.setupWithNavController(navController) //this will help navigation to the fragments
    }

    // remove this code if using BottomNavigation
    override fun onBackPressed() {
        if (drawerLayout.isOpen){
            drawerLayout.close()
        } else {
            super.onBackPressed()
        }
    }
}