package com.betrybe.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.betrybe.trybevirtualmenu.R
import com.betrybe.trybevirtualmenu.models.MenuData
import com.google.android.material.imageview.ShapeableImageView

class MenuAdapter (val Menu: List<MenuData>): Adapter<MenuAdapter.MenuViewHolder>() {
    class MenuViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val ImageDish = view.findViewById<ShapeableImageView>()
        val nameDish = view.findViewById<TextView>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int = Menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.nameDish.text = Menu[position].name
        holder.ImageDish.setImageResource(Menu[position].image)
    }
}