package com.example.customview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.customview.R
import kotlinx.android.synthetic.main.main_fragment.*

open class MainFragment(@LayoutRes val contentLayoutId: Int) : Fragment() {

    @LayoutRes
    private var mContentLayoutId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContentLayoutId = contentLayoutId

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mContentLayoutId != 0) layout_stub.layoutResource = mContentLayoutId
        layout_stub.inflate()
    }


}