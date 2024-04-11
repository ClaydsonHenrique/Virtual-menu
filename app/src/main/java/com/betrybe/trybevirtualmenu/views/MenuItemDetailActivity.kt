package com.betrybe.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybevirtualmenu.R
import com.betrybe.trybevirtualmenu.models.MenuDatabase
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuItemDetailActivity : AppCompatActivity() {

//    private val image: ShapeableImageView by lazy { findViewById(R.id.detail_image) }
//    private val name: MaterialTextView by lazy { findViewById(R.id.detail_name) }
//    private val description: MaterialTextView by lazy { findViewById(R.id.detail_description) }
//    private val price: MaterialTextView by lazy { findViewById(R.id.detail_price) }
    private val back: MaterialButton by lazy { findViewById(R.id.detail_back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        val menuId = intent.getIntExtra("menu_id", 0)

        val getMenuId = MenuDatabase.getMenubyId(menuId + 1)!!

//        name.text = getMenuId.name
//        image.setImageResource(getMenuId.image)
//        description.text = getMenuId.description
//
//        val formattedPrice = "R$: ${getMenuId.price}"
//        price.text = formattedPrice
//
        back.setOnClickListener{
            finish()
        }
    }
}
