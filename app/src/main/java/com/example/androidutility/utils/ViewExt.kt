@file:Suppress("NOTHING_TO_INLINE", "UNUSED_PARAMETER", "EXTENSION_SHADOWED_BY_MEMBER")

package com.example.androidutility.utils
import android.content.Context
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun ViewGroup?.inflate(
    @LayoutRes resource: Int,
    attachToRoot: Boolean = false
): View {
    return LayoutInflater.from(this?.context).inflate(resource, this, attachToRoot)
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.getString(@StringRes resId: Int): String {
    return context?.getString(resId) ?: "N/A"
}

fun View.getString(@StringRes resId: Int, vararg formatArgs: Any): String {
    return context?.getString(resId, formatArgs) ?: "N/A"
}

fun View.getColor(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(context, colorRes)
}

var lastClickTime: Long = 0
inline fun View.setOnSingleClickListener(crossinline onClick: (View) -> Unit) {
    hideKeyboard()
    setOnClickListener {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) {
            return@setOnClickListener
        }
        lastClickTime = SystemClock.elapsedRealtime()
        onClick(it)
    }
}

fun View.gone(){
    visibility =View.GONE
}

fun View.visible(){
    visibility =View.VISIBLE
}