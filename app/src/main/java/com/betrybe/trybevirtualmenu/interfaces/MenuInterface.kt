package com.betrybe.trybevirtualmenu.interfaces

import android.view.View

interface MenuInterface {
    fun onMenuClick(view: View, position: Int)
}