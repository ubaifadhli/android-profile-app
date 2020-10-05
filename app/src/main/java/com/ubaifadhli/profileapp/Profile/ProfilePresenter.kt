package com.ubaifadhli.profileapp.Profile

import com.ubaifadhli.profileapp.BaseView
import com.ubaifadhli.profileapp.Login.LoginContract
import com.ubaifadhli.profileapp.User

class ProfilePresenter (view: ProfileContract.View, user: User) : ProfileContract.Presenter {
    private var view : ProfileContract.View? = view
    private var user : User = user

    override fun onViewCreated() {
        this.view?.changeDisplayData(this.user)
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun changeActivity(user: User) {
        TODO("Not yet implemented")
    }

}