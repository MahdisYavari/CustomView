package com.example.customview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.customview.R
import com.example.customview.SingleFragmentActivity

class ResultActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return ResultFragment.newInstance()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
