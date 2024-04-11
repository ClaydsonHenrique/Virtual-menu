package com.betrybe.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybevirtualmenu.R
import com.betrybe.trybevirtualmenu.adapters.MenuAdapter
import com.betrybe.trybevirtualmenu.interfaces.MenuInterface
import com.betrybe.trybevirtualmenu.models.MenuDatabase

class MainActivity : AppCompatActivity(),MenuInterface {

    private val MenuList by lazy { findViewById<RecyclerView>(R.id.main_menu) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu = MenuDatabase.getMenu()

        val menuAdapter = MenuAdapter(menu)
        menuAdapter.setMenuListener(this)
        MenuList.layoutManager = LinearLayoutManager(this)
        MenuList.adapter = menuAdapter
    }

    override fun onMenuClick(view: View, position: Int) {
        val intent = Intent(baseContext, MenuItemDetailActivity::class.java)
        intent.putExtra("menu_id", position)
        startActivity(intent)
    }
}
