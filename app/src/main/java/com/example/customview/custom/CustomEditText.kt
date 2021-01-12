package com.example.customview.custom

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doAfterTextChanged
import com.example.customview.R
import com.example.customview.extensions.setLeftDrawable
import com.example.customview.extensions.setRightDrawable
import com.example.customview.extensions.toasty

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = androidx.appcompat.R.attr.editTextStyle,
) : AppCompatEditText(context, attributeSet, defStyle) {



    init {
        setLeftDrawable(R.drawable.ic_contact_book)
        setTextChangeListener()
        setDrawablesListener()
    }


    companion object {
        private const val DRAWABLE_LEFT_INDEX = 0
        private const val DRAWABLE_RIGHT_INDEX = 2
    }

    private fun setTextChangeListener() {
        doAfterTextChanged {
            if (it?.length == 11) {
                if (it.startsWith("0935")) {
                    setRightDrawable(R.drawable.ic_irancell)
                    toasty(context, "ایرانسل", 4)
                } else if (it.startsWith("0912")) {
                    setRightDrawable(R.drawable.ic_hamrah_1)
                    toasty(context, "همراه اول", 4)
                }
            } else {
                setRightDrawable(0)
            }
        }
    }


    private fun setDrawablesListener() {
        setOnTouchListener(OnTouchListener { view, event ->
            view.performClick()
            if (event.action == MotionEvent.ACTION_UP) {
                when {
                    rightDrawableClicked(event) -> {
                        toasty(context, "clicked", 4)
                        return@OnTouchListener true
                    }
                    leftDrawableClicked(event) -> {
                        toasty(context, "clicked", 4)
                        // implicit intent to contact book
                        return@OnTouchListener true
                    }
                    else -> {
                        return@OnTouchListener false
                    }
                }
            }
            false
        })
    }

    private fun rightDrawableClicked(event: MotionEvent): Boolean {

        val rightDrawable = compoundDrawables[DRAWABLE_RIGHT_INDEX]

        return if (rightDrawable == null) {
            false
        } else {
            val startOfDrawable = width - rightDrawable.bounds.width() - paddingRight
            val endOfDrawable = startOfDrawable + rightDrawable.bounds.width()
            startOfDrawable <= event.x && event.x <= endOfDrawable
        }

    }

    private fun leftDrawableClicked(event: MotionEvent): Boolean {

        val leftDrawable = compoundDrawables[DRAWABLE_LEFT_INDEX]

        return if (leftDrawable == null) {
            false
        } else {
            val startOfDrawable = paddingLeft
            val endOfDrawable = startOfDrawable + leftDrawable.bounds.width()
            startOfDrawable <= event.x && event.x <= endOfDrawable
        }

    }
}