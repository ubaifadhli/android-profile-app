package com.ubaifadhli.profileapp

import android.app.Activity
import kotlin.reflect.KClass

interface BaseView<T> {
    fun setPresenter(presenter : T)
    fun navigateToActivity(activity : KClass<out Activity>)
}