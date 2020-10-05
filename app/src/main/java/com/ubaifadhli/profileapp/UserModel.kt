package com.ubaifadhli.profileapp

class UserModel : BaseModel<User>{
    override fun fetchData(): ArrayList<User> {
        var userList = ArrayList<User>()
        userList.add(User("Ubai", "123", "2110181043"))

        return userList
    }

}