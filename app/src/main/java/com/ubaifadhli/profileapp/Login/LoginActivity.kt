package com.ubaifadhli.profileapp.Login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ubaifadhli.profileapp.R
import com.ubaifadhli.profileapp.User
import com.ubaifadhli.profileapp.UserModel
import kotlin.reflect.KClass

class LoginActivity : AppCompatActivity(), LoginContract.View {
    internal lateinit var loginButton: Button
    internal lateinit var usernameTE: EditText
    internal lateinit var passwordTE: EditText

    internal lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.loginButton)
        usernameTE = findViewById(R.id.usernameTE)
        passwordTE = findViewById(R.id.passwordTE)

        presenter = LoginPresenter(this, UserModel())

        loginButton.setOnClickListener { onButtonClicked() }
    }

    fun onButtonClicked() {
        var username = usernameTE.text.toString()
        var password = passwordTE.text.toString()

        presenter.onLoginButtonClicked(username, password)
    }

    override fun navigateToActivity(activity: KClass<out Activity>, user : User) {
        var profileIntent = Intent(this, activity.java)
        profileIntent.putExtra("User", user)
        startActivity(profileIntent)
    }

    override fun navigateToActivity(activity: KClass<out Activity>) {
        // Should be error.
        showLoginFailedToast()
    }

    override fun showLoginFailedToast() {
        Toast.makeText(this, "Login failed. Please try again.", Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        this.presenter = presenter
    }




}