package com.example.customview.extensions

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import es.dmoral.toasty.Toasty

private const val DRAWABLE_LEFT_INDEX = 0
private const val DRAWABLE_TOP_INDEX = 1
private const val DRAWABLE_RIGHT_INDEX = 2
private const val DRAWABLE_BOTTOM_INDEX = 3

fun toasty(context: Context, message: String, type: Int = 1, length: Int = Toast.LENGTH_SHORT) {
    /**
     * 1 normal
     * 2 success
     * 3 error
     * 4 info
     * 5 warning
     */
    when (type) {
        1 -> Toasty.normal(context, message, length).show()
        2 -> Toasty.success(context, message, length).show()
        3 -> Toasty.error(context, message, length).show()
        4 -> Toasty.info(context, message, length).show()
        5 -> Toasty.warning(context, message, length).show()
    }
}

fun TextView.setLeftDrawable(@DrawableRes drawableResId: Int) {

    val leftDrawable = if (drawableResId != 0) {
        ContextCompat.getDrawable(context, drawableResId)
    } else {
        null
    }
    val topDrawable = compoundDrawables[DRAWABLE_TOP_INDEX]
    val rightDrawable = compoundDrawables[DRAWABLE_RIGHT_INDEX]
    val bottomDrawable = compoundDrawables[DRAWABLE_BOTTOM_INDEX]

    setCompoundDrawablesWithIntrinsicBounds(
        leftDrawable,
        topDrawable,
        rightDrawable,
        bottomDrawable
    )

}

fun TextView.setRightDrawable(@DrawableRes drawableResId: Int) {

    val leftDrawable = compoundDrawables[DRAWABLE_LEFT_INDEX]
    val topDrawable = compoundDrawables[DRAWABLE_TOP_INDEX]
    val rightDrawable = if (drawableResId != 0) {
        ContextCompat.getDrawable(context, drawableResId)
    } else {
        null
    }
    val bottomDrawable = compoundDrawables[DRAWABLE_BOTTOM_INDEX]

    setCompoundDrawablesWithIntrinsicBounds(
        leftDrawable,
        topDrawable,
        rightDrawable,
        bottomDrawable
    )

}
