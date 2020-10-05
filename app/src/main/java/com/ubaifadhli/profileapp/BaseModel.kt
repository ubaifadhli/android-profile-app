package com.ubaifadhli.profileapp

interface BaseModel<T> {
    fun fetchData() : ArrayList<T>
}