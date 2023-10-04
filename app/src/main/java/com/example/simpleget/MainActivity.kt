package com.example.simpleget

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import android.view.LayoutInflater as LayoutInflater1


const val geturl="https://gorest.co.in/public/v2/"
const val posturl="https://gorest.co.in/public/v2/"
const val puturl="https://gorest.co.in/public/v2/"
const val delurl="https://gorest.co.in/public/v2/"
class MainActivity : AppCompatActivity() {



private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment= supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            navController=navHostFragment.navController
        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}





