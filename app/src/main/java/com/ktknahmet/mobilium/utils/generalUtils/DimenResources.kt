@file:Suppress("NOTHING_TO_INLINE", "unused")
package com.ktknahmet.mobilium.utils.generalUtils

import android.content.Context
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import com.ktknahmet.mobilium.utils.appCtx

inline fun Context.dimen(@DimenRes dimenResId: Int): Float = resources.getDimension(dimenResId)
inline fun Fragment.dimen(@DimenRes dimenResId: Int) = context!!.dimen(dimenResId)
inline fun View.dimen(@DimenRes dimenResId: Int) = context.dimen(dimenResId)
/**
 * Use this method for non configuration dependent resources when you don't have a [Context]
 * or when you're calling it from an Activity or a Fragment member (as the Context is not
 * initialized yet).
 *
 * For theme dependent resources, the application theme will be implicitly used.
 */
inline fun appDimen(@DimenRes dimenResId: Int) = appCtx.dimen(dimenResId)

inline fun Context.dimenPxSize(
    @DimenRes dimenResId: Int
): Int = resources.getDimensionPixelSize(dimenResId)

inline fun Fragment.dimenPxSize(@DimenRes dimenResId: Int) = context!!.dimenPxSize(dimenResId)
inline fun View.dimenPxSize(@DimenRes dimenResId: Int) = context.dimenPxSize(dimenResId)
/**
 * Use this method for non configuration dependent resources when you don't have a [Context]
 * or when you're calling it from an Activity or a Fragment member (as the Context is not
 * initialized yet).
 *
 * For theme dependent resources, the application theme will be implicitly used.
 */
inline fun appDimenPxSize(@DimenRes dimenResId: Int) = appCtx.dimenPxSize(dimenResId)

inline fun Context.dimenPxOffset(
    @DimenRes dimenResId: Int
): Int = resources.getDimensionPixelOffset(dimenResId)

inline fun Fragment.dimenPxOffset(@DimenRes dimenResId: Int) = context!!.dimenPxOffset(dimenResId)
inline fun View.dimenPxOffset(@DimenRes dimenResId: Int) = context.dimenPxOffset(dimenResId)
/**
 * Use this method for non configuration dependent resources when you don't have a [Context]
 * or when you're calling it from an Activity or a Fragment member (as the Context is not
 * initialized yet).
 *
 * For theme dependent resources, the application theme will be implicitly used.
 */
inline fun appDimenPxOffset(@DimenRes dimenResId: Int) = appCtx.dimenPxOffset(dimenResId)

// Styled resources below

fun Context.styledDimen(@AttrRes attr: Int): Float = dimen(resolveThemeAttribute(attr))
inline fun Fragment.styledDimen(@AttrRes attr: Int) = context!!.styledDimen(attr)
inline fun View.styledDimen(@AttrRes attr: Int) = context.styledDimen(attr)
/**
 * Use this method for non configuration dependent resources when you don't have a [Context]
 * or when you're calling it from an Activity or a Fragment member (as the Context is not
 * initialized yet).
 *
 * For theme dependent resources, the application theme will be implicitly used.
 */
inline fun appStyledDimen(@AttrRes attr: Int) = appCtx.styledDimen(attr)

fun Context.styledDimenPxSize(@AttrRes attr: Int): Int = dimenPxSize(resolveThemeAttribute(attr))
inline fun Fragment.styledDimenPxSize(@AttrRes attr: Int) = context!!.styledDimenPxSize(attr)
inline fun View.styledDimenPxSize(@AttrRes attr: Int) = context.styledDimenPxSize(attr)
/**
 * Use this method for non configuration dependent resources when you don't have a [Context]
 * or when you're calling it from an Activity or a Fragment member (as the Context is not
 * initialized yet).
 *
 * For theme dependent resources, the application theme will be implicitly used.
 */
inline fun appStyledDimenPxSize(@AttrRes attr: Int) = appCtx.styledDimenPxSize(attr)

fun Context.styledDimenPxOffset(
    @AttrRes attr: Int
): Int = dimenPxOffset(resolveThemeAttribute(attr))

inline fun Fragment.styledDimenPxOffset(@AttrRes attr: Int) = context!!.styledDimenPxOffset(attr)
inline fun View.styledDimenPxOffset(@AttrRes attr: Int) = context.styledDimenPxOffset(attr)
/**
 * Use this method for non configuration dependent resources when you don't have a [Context]
 * or when you're calling it from an Activity or a Fragment member (as the Context is not
 * initialized yet).
 *
 * For theme dependent resources, the application theme will be implicitly used.
 */
inline fun appStyledDimenPxOffset(@AttrRes attr: Int) = appCtx.styledDimenPxOffset(attr)
