package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.viewModels.ShoesViewModel

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

        setHasOptionsMenu(true)

        val viewModel: ShoesViewModel by activityViewModels()
        binding.shoesViewModel = viewModel

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

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoes_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}