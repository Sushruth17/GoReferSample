package com.example.sample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sample.R
import com.example.sample.UtilsString
import kotlinx.android.synthetic.main.layoutitem.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconLogo: ImageView = itemView.icon
        val text: TextView = itemView.name
        val arrow: ImageView = itemView.arrow
    }


    lateinit var data:List<String>
    fun setDataCustom(data: List<String>){
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate
                (R.layout.layoutitem, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val unitData: String? = data[position]
        if (unitData != null) {
            holder.text.text = unitData
            holder.arrow.setImageResource(R.drawable.ic_arrow)
            if (unitData == UtilsString.MY_PROFILE)
                holder.iconLogo.setImageResource(R.drawable.ic_my_profile)
            if (unitData == UtilsString.MY_REQUESTS)
                holder.iconLogo.setImageResource(R.drawable.ic_my_requests)
            if (unitData == UtilsString.MY_OFFERINGS)
                holder.iconLogo.setImageResource(R.drawable.ic_my_offerings)
            if (unitData == UtilsString.MY_RECOMMENDATIONS)
                holder.iconLogo.setImageResource(R.drawable.ic_my_recommendations)
            if (unitData == UtilsString.SUPPORT)
                holder.iconLogo.setImageResource(R.drawable.ic_support)
        }
    }

}


