package com.example.weatherapp.presentation.weekweather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ItemWeekWeatherBinding
import com.example.weatherapp.domain.model.WeekWeatherModel
import com.squareup.picasso.Picasso
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

class WeekWeatherAdapter : RecyclerView.Adapter<WeekWeatherAdapter.ItemHolder>() {
    private val weekWeathers= mutableListOf<WeekWeatherModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_week_weather, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(weekWeathers[position])
    }

    override fun getItemCount(): Int = weekWeathers.size

    fun update(weathers: List<WeekWeatherModel>) {
        weekWeathers.clear()
        weekWeathers.addAll(weathers)
        notifyDataSetChanged()
    }

    class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        private var binding: ItemWeekWeatherBinding = DataBindingUtil.bind(view)!!

        fun bind(weekWeather: WeekWeatherModel) {
            binding.weekItem = weekWeather
            binding.executePendingBindings()

            Picasso.get()
                .load(String.format(BuildConfig.ICON_URL, weekWeather.icon))
                .into(binding.iconWeatherId)

            when (adapterPosition) {
                0 -> binding.dayTitle.text = itemView.context.getString(R.string.today)
                1 -> binding.dayTitle.text = itemView.context.getString(R.string.tomorow)
                else -> {
                    binding.dayTitle.text = LocalDate.now()
                        .plusDays(adapterPosition.toLong())
                        .format(DateTimeFormatter.ofPattern("EEEE"))
                        .capitalize()
                }
            }
        }
    }
}