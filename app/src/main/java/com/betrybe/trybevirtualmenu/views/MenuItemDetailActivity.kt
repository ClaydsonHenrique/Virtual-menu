package com.betrybe.trybevirtualmenu.views

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybevirtualmenu.R
import com.betrybe.trybevirtualmenu.models.MenuDatabase

class MenuItemDetailActivity : AppCompatActivity() {

    private val image: ImageView by lazy { findViewById(R.id.detail_image) }
    private val name: TextView by lazy { findViewById(R.id.detail_name) }
    private val description: TextView by lazy { findViewById(R.id.detail_description) }
    private val price: TextView by lazy { findViewById(R.id.detail_price) }

    private val back: Button by lazy { findViewById(R.id.detail_back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        val menuId = intent.getIntExtra("menu_id", 0)
        val getMenuId = MenuDatabase.getMenuById(menuId + 1)!!

        name.text = getMenuId.name
        image.setImageResource(getMenuId.image)
        description.text = getMenuId.description
        price.text = getMenuId.price.toString()
//
        back.setOnClickListener{
            finish()
        }
    }
}
