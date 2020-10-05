package com.ubaifadhli.profileapp

interface BasePresenter {
    fun onDestroy()
    fun changeActivity(user: User)
}