package com.example.main_module.v

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_module.utils.RouteUtils
import com.example.common_module.utils.startActivity
import com.example.main_module.R
import com.example.main_module.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_home.*

@Route(path = "/main/MainActivity")
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var chatsFragment: Fragment? = null
    var contactsFragment: ContactsFragment = ContactsFragment()
    var discoverFragment: DiscoverFragment = DiscoverFragment()
    var gameFragment: GameFragment = GameFragment()
    var meFragment: MeFragment = MeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        BottomNavigationViewHelper.disableShiftMode(navigation)
        navigation.setOnNavigationItemSelectedListener(this)
//        button.setOnClickListener {
//            startActivity<DetialActivity>()
//        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        chatsFragment = RouteUtils.routerFragment(RouteUtils.CHAT_FRAGMENT)

        when (item.itemId) {
            R.id.action_chats -> supportFragmentManager.beginTransaction().replace(R.id.content, chatsFragment).commit()
            R.id.action_contacts -> supportFragmentManager.beginTransaction().replace(R.id.content, contactsFragment).commit()
            R.id.action_discover -> supportFragmentManager.beginTransaction().replace(R.id.content, discoverFragment).commit()
            R.id.action_game -> supportFragmentManager.beginTransaction().replace(R.id.content, gameFragment).commit()
            R.id.action_me -> supportFragmentManager.beginTransaction().replace(R.id.content, meFragment).commit()

        }
        return true
    }
}

