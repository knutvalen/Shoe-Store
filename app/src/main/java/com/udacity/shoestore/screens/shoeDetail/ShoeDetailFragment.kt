package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModels.ShoesViewModel

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        val viewModel: ShoesViewModel by activityViewModels()
        binding.shoesViewModel = viewModel

        viewModel.eventSave.observe(viewLifecycleOwner, Observer {
            if (it) {
                val name = binding.shoeNameEditText.text.toString()
                val size = binding.shoeSizeEditText.text.toString()
                val company = binding.companyEditText.text.toString()
                val description = binding.descriptionEditText.text.toString()

                if (
                    name.isNotEmpty()
                    && size.isNotEmpty()
                    && company.isNotEmpty()
                    && description.isNotEmpty()
                ) {
                    val shoe = Shoe(
                        name,
                        size.toDouble(),
                        company,
                        description
                    )

                    viewModel.onSave(shoe)
                    viewModel.onSaveComplete()
                    done()
                }
            }
        })

        viewModel.eventCancel.observe(viewLifecycleOwner, Observer {
            if (it) {
                viewModel.onCancelComplete()
                done()
            }
        })

        return binding.root
    }

    private fun done() {
        findNavController().navigate(
            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesFragment()
        )
    }

}