package com.ubaifadhli.profileapp.Login

import com.ubaifadhli.profileapp.Profile.ProfileActivity
import com.ubaifadhli.profileapp.User
import com.ubaifadhli.profileapp.UserModel


class LoginPresenter(view: LoginContract.View, model : UserModel) : LoginContract.Presenter {
    private var view : LoginContract.View? = view
    private var model : UserModel = model

    override fun onLoginButtonClicked(username: String, password: String) {
        var foundUser = validateLogin(username, password)

        if(foundUser != null)
            changeActivity(foundUser)
        else
            this.view?.showLoginFailedToast()

    }

    override fun validateLogin(username: String, password: String) : User? {
        for (user in model.fetchData()) {
            if (user.username == username && user.password == password)
                return user
        }
        return null
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun changeActivity(user: User) {
        this.view?.navigateToActivity(ProfileActivity::class, user)
    }
}