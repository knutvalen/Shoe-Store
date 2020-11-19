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

    private lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityShoesBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_shoes
        )

        val navController = this.findNavController(R.id.shoes_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        if (savedInstanceState != null) {
            //TODO
        }

        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)
        binding.shoesViewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.shoes_nav_host_fragment)
        return navController.navigateUp()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //TODO
    }

}