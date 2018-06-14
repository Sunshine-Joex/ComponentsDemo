package com.example.main_module.utils

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView

object BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    fun disableShiftMode(navigationView: BottomNavigationView) {
        val menuView = navigationView.getChildAt(0) as BottomNavigationMenuView
        try
        {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.setAccessible(true)
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.setAccessible(false)
            for (i in 0 until menuView.getChildCount())
            {
                val itemView = menuView.getChildAt(i) as BottomNavigationItemView
                itemView.setShiftingMode(false)
                itemView.setChecked(itemView.getItemData().isChecked())
            }
        }
        catch (e:NoSuchFieldException) {
            // Log
        }
        catch (e:IllegalAccessException) {
            // Log
        }
    }
}