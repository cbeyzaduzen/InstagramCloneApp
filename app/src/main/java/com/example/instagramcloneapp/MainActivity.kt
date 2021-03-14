package com.example.instagramcloneapp

import Fragments.HomeFragment
import Fragments.NotificationsFragment
import Fragments.ProfileFragment
import Fragments.SearchFragment
import android.app.Notification
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    internal var selectedFragment:Fragment?=null


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {

                selectedFragment=HomeFragment()

            }
            R.id.nav_search -> {

                selectedFragment=SearchFragment()

            }
            R.id.nav_add_post -> {

                return@OnNavigationItemSelectedListener true

            }
            R.id.nav_notification -> {

                selectedFragment= NotificationsFragment()

            }
            R.id.nav_profile -> {

                selectedFragment= ProfileFragment()

            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, HomeFragment()
        ).commit()


    }



}
