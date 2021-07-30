package com.peculiaruc.tourdeglob.ui.cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.tourdeglob.R
import com.peculiaruc.tourdeglob.ui.adapters.CitiesAdapter
import com.sriyank.globotour.city.VacationSpots


class CityListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_city_list, container, false)

        setupRecyclerView(view)
        return view

    }

    private fun setupRecyclerView(view: View?) {
      val context = requireContext()

        //call the adapter
        val cityAdapter = CitiesAdapter(context, VacationSpots.cityList!!)

        //add the recyclerView
        val recyclerView = view?.findViewById<RecyclerView>(R.id.cities_recycler_View)
        recyclerView?.adapter = cityAdapter
        recyclerView?.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.layoutManager = layoutManager

    }


}