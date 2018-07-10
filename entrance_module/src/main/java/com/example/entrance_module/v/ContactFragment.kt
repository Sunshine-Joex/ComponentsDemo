package com.example.entrance_module.v

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_module.utils.RouteUtils

import com.example.entrance_module.R

@Route(path = RouteUtils.CONTACT_FRAGMENT)
class ContactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }
}
