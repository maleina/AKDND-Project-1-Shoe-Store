package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeStoreViewModel
import kotlinx.android.synthetic.main.shoe_layout.view.*

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)

        // set life cycle owner in order to use data binding to populate the shoe list
        binding.lifecycleOwner = this

        // Add each shoe in the shoe list to the scrollable view
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->
                val listItem : View = inflater.inflate(R.layout.shoe_layout, null, false)
                listItem.name_text.text = shoe.name
                listItem.size_text.text = shoe.size.toString()
                listItem.company_text.text = shoe.company
                listItem.description_text.text = shoe.description
                binding.shoeListLayout.addView(listItem)
            }
        })

        return binding.root
    }
}