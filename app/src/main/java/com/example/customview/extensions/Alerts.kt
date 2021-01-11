package com.example.customview.extensions

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty

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