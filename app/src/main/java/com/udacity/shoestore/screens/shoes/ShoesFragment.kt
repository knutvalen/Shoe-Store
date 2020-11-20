package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginStart
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModels.ShoesViewModel
import timber.log.Timber

class ShoesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoes,
            container,
            false
        )

        val viewModel: ShoesViewModel by activityViewModels()

        viewModel.eventAdd.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(
                    ShoesFragmentDirections.actionShoesFragmentToShoeDetailFragment()
                )

                viewModel.onAddComplete()
            }
        })

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            binding.shoesLinearLayout.removeAllViews()
            shoes.map { shoe ->
                val textView = TextView(context)
                textView.text = "$shoe.toString() \n\n"
                binding.shoesLinearLayout.addView(textView)
            }
        })

        binding.shoesViewModel = viewModel

        return binding.root
    }

}