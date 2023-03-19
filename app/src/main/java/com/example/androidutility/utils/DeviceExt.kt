package com.example.androidutility.utils
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics


fun Int.dpToPx(): Int = (this * getDisplayMetrics().density).toInt()

fun Int.pxToDp(): Int = (this / getDisplayMetrics().density).toInt()

fun getWidthPixels() = getDisplayMetrics().widthPixels

fun getHeightPixels() = getDisplayMetrics().heightPixels

fun getDisplayMetrics(): DisplayMetrics = Resources.getSystem().displayMetrics

fun getDeviceName(): String = Build.BRAND + " " + Build.MODEL

fun getDeviceModel(): String = Build.MODEL


