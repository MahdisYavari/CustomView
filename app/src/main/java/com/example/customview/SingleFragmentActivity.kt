package com.example.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open abstract class SingleFragmentActivity : AppCompatActivity() {
    abstract fun  createFragment() : Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_fragment)


        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null)
            fragmentManager.beginTransaction().add(R.id.fragment_container,createFragment())
                .commit()

    }
}