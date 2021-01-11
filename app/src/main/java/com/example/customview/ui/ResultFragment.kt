package com.example.customview.ui

import android.os.Bundle
import com.example.customview.MainFragment
import com.example.customview.R

class ResultFragment : MainFragment(R.layout.result_fragment){

    companion object{

        fun newInstance() : ResultFragment {
            val args = Bundle()
            val fragment = ResultFragment()
            fragment.arguments = args
            return fragment

        }
    }

}