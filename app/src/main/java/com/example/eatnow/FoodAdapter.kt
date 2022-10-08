package com.example.eatnow

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eatnow.databinding.RowRecyclerFoodBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class FoodAdapter(private val foods:ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {



    inner class ViewHolder(private val binding:RowRecyclerFoodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(food:Food) {

            binding.rowTxtFoodName.text = food.txtSubject
            binding.rowTxtFoodCity.text = food.txtCity
            binding.rowTxtFoodDistance.text = food.txtDistance + " miles from you"
            binding.rowTxtFoodPrice.text = "$" + food.txtPrice + " vip"
            binding.rowFoodRatingBar.rating = food.rating
            binding.rowFoodRatersCount.text = "( ${food.ratersCount} Ratings)"

            Glide.with(binding.root.context).load(food.urlImage)
                .transform(RoundedCornersTransformation(16, 4)).into(binding.rowImgMain)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = RowRecyclerFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(foods[position])
    }

    override fun getItemCount() = foods.size


}