package com.ubaifadhli.profileapp.Login

import android.app.Activity
import com.ubaifadhli.profileapp.BasePresenter
import com.ubaifadhli.profileapp.BaseView
import com.ubaifadhli.profileapp.User
import kotlin.reflect.KClass

interface LoginContract {
    interface Presenter : BasePresenter {
        fun onLoginButtonClicked(username: String, password: String)
        fun validateLogin(username : String, password : String) : User?
    }

    interface View : BaseView<Presenter> {
        fun showLoginFailedToast()
        fun navigateToActivity(activity: KClass<out Activity>, user : User)
    }

}