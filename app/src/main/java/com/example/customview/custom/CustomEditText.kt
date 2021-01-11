package com.example.customview.custom

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.appcompat.widget.AppCompatEditText
import com.example.customview.R
import com.example.customview.extensions.setLeftDrawable
import com.example.customview.extensions.toasty

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = androidx.appcompat.R.attr.editTextStyle
) : AppCompatEditText(context, attributeSet, defStyle) {



    init {
        setLeftDrawable(R.drawable.ic_contact_book)
        setDrawablesListener()
    }


    companion object {
        private const val DRAWABLE_LEFT_INDEX = 0
        private const val DRAWABLE_RIGHT_INDEX = 2
    }


    private fun setDrawablesListener() {
        setOnTouchListener(OnTouchListener { view, event ->
            view.performClick()
            if (event.action == MotionEvent.ACTION_UP) {
                when {
                    rightDrawableClicked(event) -> {
                        toasty(context, R.string.phone_type.toString(),4)
                        return@OnTouchListener true
                    }
                    leftDrawableClicked(event) -> {
                        toasty(context, R.string.phone_type.toString(),4)
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