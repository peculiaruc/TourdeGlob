package com.peculiaruc.tourdeglob.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.tourdeglob.R
import com.sriyank.globotour.city.City
import com.sriyank.globotour.city.VacationSpots

class CitiesAdapter(val context: Context, var cityList: ArrayList<City>)
    : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_city, parent, false)
        return CitiesViewHolder(itemView)
    }

    override fun onBindViewHolder(citieViewHolder: CitiesViewHolder, position: Int) {

       Log.i("CitiesAdapter", "onBindViewHolder: position: $position")
        val city = cityList[position]
        citieViewHolder.setData(city, position)
        //create onclick for fav and delete
        citieViewHolder.setListeners()
    }

    override fun getItemCount(): Int = cityList.size

    inner class CitiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var currentPosition: Int = -1
        private var currentCity: City? = null

        private val cityName = itemView.findViewById<TextView>(R.id.txv_city_name)
        private val cityImage = itemView.findViewById<ImageView>(R.id.imv_city)
        private val deleteImage = itemView.findViewById<ImageView>(R.id.imv_delete)
        private val favouriteImage = itemView.findViewById<ImageView>(R.id.imv_favorite)

        //get the likes drawable
        private val icFavoriteFilledImage = ResourcesCompat.getDrawable(context.resources,
        R.drawable.ic_favorite_filled, null)
        private val icFavouriteBorderedImage = ResourcesCompat.getDrawable(context.resources,
        R.drawable.ic_favorite_bordered, null)

        fun setData(city: City, position: Int) {
            this.currentPosition = position
            this.currentCity = city

            cityName.text = city.name
            cityImage.setImageResource(city.imageId)
            if (city.isFavorite)
                favouriteImage.setImageDrawable(icFavoriteFilledImage)
            else
                favouriteImage.setImageDrawable(icFavouriteBorderedImage)
        }

        //to delete, like or unlike image
        fun setListeners() {
            favouriteImage.setOnClickListener {}
            deleteImage.setOnClickListener { }
        }

        override fun onClick(v: View?) {
            when(v!!.id){
                R.id.imv_delete -> deleteImageItem()
                R.id.imv_favorite -> addFavourite()
            }

        }

        private fun deleteImageItem() {
            cityList.removeAt(currentPosition)
            notifyItemRemoved(currentPosition)
            notifyItemRangeChanged(currentPosition, cityList.size)

            VacationSpots.favoriteCityList.remove(currentCity!!)
        }

        private fun addFavourite() {
           currentCity?.isFavorite = !(currentCity?.isFavorite!!) //toggle isFavourite image, update or remove the icon

            if (currentCity?.isFavorite!!) {
                favouriteImage.setImageDrawable(icFavoriteFilledImage)
                VacationSpots.favoriteCityList.add(currentCity!!)
            }else {
                favouriteImage.setImageDrawable(icFavouriteBorderedImage)
                VacationSpots.favoriteCityList.remove(currentCity!!)
            }
        }



    }
}