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

class MenuAdapter (private val menu: List<MenuData>):
    Adapter<MenuAdapter.MenuViewHolder>() {

    private var menuList: MenuInterface? = null

    fun setMenuListener(list:MenuInterface){
        this.menuList = list
    }

    class MenuViewHolder (view: View, menuList: MenuInterface?) : RecyclerView.ViewHolder(view){
        val imageDish: ShapeableImageView = view.findViewById(R.id.item_menu_image)
        val nameDish: TextView = view.findViewById(R.id.item_menu_name)

        init {
            view.setOnClickListener{
                menuList?.onMenuClick(view, absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return MenuViewHolder(view, menuList)
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.nameDish.text = menu[position].name
        holder.imageDish.setImageResource(menu[position].image)
    }
}