package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeStoreViewModel

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false)

        // configure view model and life cycle owner
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // initialize "empty" shoe values
        binding.shoe = Shoe("",0.0,"","")

        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.eventShoeAdded.observe(viewLifecycleOwner, Observer { shoeAdded ->
            if (shoeAdded){
                findNavController().popBackStack()
                viewModel.onNavigateComplete()
            }
        })

        return binding.root
    }

}