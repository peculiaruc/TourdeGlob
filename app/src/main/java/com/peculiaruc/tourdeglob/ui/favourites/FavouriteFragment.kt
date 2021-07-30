package com.peculiaruc.tourdeglob.ui.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.tourdeglob.R
import com.peculiaruc.tourdeglob.ui.adapters.FavouriteAdapter
import com.sriyank.globotour.city.City
import com.sriyank.globotour.city.VacationSpots


class FavouriteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourite, container, false)

        setUpFavRecyclerView()
        return view
    }

    private fun setUpFavRecyclerView() {
        val context = requireContext()

        val favouriteCityList = VacationSpots.favoriteCityList as ArrayList<City>
        val  favouriteAdapter = FavouriteAdapter(context, favouriteCityList)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.favorite_recycler_View)
        recyclerView?.adapter = favouriteAdapter
        recyclerView?.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.layoutManager = layoutManager

    }


}