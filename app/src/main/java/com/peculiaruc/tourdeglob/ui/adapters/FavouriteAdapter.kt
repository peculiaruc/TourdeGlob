package com.peculiaruc.tourdeglob.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.tourdeglob.R
import com.sriyank.globotour.city.City

class FavouriteAdapter(val context: Context, var favList : ArrayList<City>) : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
    val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_favorite, parent, false)
        return FavouriteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = favList.size

    inner class FavouriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentPosition: Int = -1
        private var currentCity: City? = null

        private val txCityName = itemView.findViewById<TextView>(R.id.txv_city_name)
        private val cityImage = itemView.findViewById<ImageView>(R.id.imv_city)

        fun setData(city: City, position: Int){
            txCityName.text = city.name
            cityImage.setImageResource(city.imageId)

            this.currentPosition = position
            this.currentCity = city



        }
    }
}