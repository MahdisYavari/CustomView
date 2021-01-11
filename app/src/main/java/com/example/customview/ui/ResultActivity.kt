package com.example.customview.ui

import androidx.fragment.app.Fragment
import com.example.customview.SingleFragmentActivity

class ResultActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return ResultFragment.newInstance()
    }

}
