package com.example.cocktail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktail.R
import com.example.cocktail.databinding.ActivityMainBinding
import com.example.cocktail.databinding.RowDrinkBinding
import com.example.cocktail.model.Cocktails
import com.example.cocktail.model.Drink

class Drinkadapter : ListAdapter<Drink,Drinkadapter.MyViewHolder>(SampleItemDiffCallback()) {

    class MyViewHolder (val itemBinding: RowDrinkBinding):RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = RowDrinkBinding.inflate(view,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val drinkList = getItem(position)

        holder.itemBinding.textView.text = drinkList.strDrink
        Glide.with(holder.itemView.context)
            .load(drinkList.strDrinkThumb)
            .into(holder.itemBinding.imageView)

    }


}
class SampleItemDiffCallback : DiffUtil.ItemCallback<Drink>() {
    override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean = oldItem == newItem

}






