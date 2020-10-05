package com.ubaifadhli.profileapp.Profile

import com.ubaifadhli.profileapp.BasePresenter
import com.ubaifadhli.profileapp.BaseView
import com.ubaifadhli.profileapp.User

interface ProfileContract {
    interface Presenter : BasePresenter{
        fun onViewCreated()
    }

    interface View : BaseView<Presenter> {
        fun changeDisplayData(user : User)
    }
}