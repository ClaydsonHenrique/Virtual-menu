package com.betrybe.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.betrybe.trybevirtualmenu.R
import com.betrybe.trybevirtualmenu.interfaces.MenuInterface
import com.betrybe.trybevirtualmenu.models.MenuData
import com.google.android.material.imageview.ShapeableImageView

class MenuAdapter (val Menu: List<MenuData>): Adapter<MenuAdapter.MenuViewHolder>() {

    private var MenuList: MenuInterface? = null

    fun setMenuListener(list:MenuInterface){
        this.MenuList = list
    }

    class MenuViewHolder (view: View, MenuList: MenuInterface?) : RecyclerView.ViewHolder(view){
        val ImageDish = view.findViewById<ShapeableImageView>(R.id.item_menu_image)
        val nameDish = view.findViewById<TextView>(R.id.item_menu_name)

        init {
            view.setOnClickListener{
                MenuList?.onMenuClick(view, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return MenuViewHolder(view, MenuList)
    }

    override fun getItemCount(): Int = Menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.nameDish.text = Menu[position].name
        holder.ImageDish.setImageResource(Menu[position].image)
    }
}