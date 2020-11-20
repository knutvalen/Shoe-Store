package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityShoesBinding
import com.udacity.shoestore.viewModels.ShoesViewModel

class ShoesActivity : AppCompatActivity(), LifecycleObserver {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityShoesBinding>(
            this,
            R.layout.activity_shoes
        )

        val navController = this.findNavController(R.id.shoes_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.shoes_nav_host_fragment)
        return navController.navigateUp()
    }

}