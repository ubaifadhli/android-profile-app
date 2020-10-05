package com.ubaifadhli.profileapp.Profile

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ubaifadhli.profileapp.R
import com.ubaifadhli.profileapp.User
import kotlin.reflect.KClass

class ProfileActivity : AppCompatActivity(), ProfileContract.View {
    internal lateinit var headerTV: TextView
    internal lateinit var usernameTV: TextView
    internal lateinit var passwordTV: TextView
    internal lateinit var nrpTV: TextView

    internal lateinit var presenter: ProfileContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var intent = getIntent()
        var user = intent.extras?.getSerializable("User") as User

        headerTV = findViewById(R.id.headerTV)
        usernameTV = findViewById(R.id.usernameTV)
        passwordTV = findViewById(R.id.passwordTV)
        nrpTV = findViewById(R.id.nrpTV)

        presenter = ProfilePresenter(this, user)
        presenter.onViewCreated()
    }

    override fun changeDisplayData(user: User) {
        headerTV.setText(getString(R.string.hello_username_text, user.username))
        usernameTV.setText(getString(R.string.username_text, user.username))
        passwordTV.setText(getString(R.string.password_text, user.password))
        nrpTV.setText(getString(R.string.nrp_text, user.nrp))
    }

    override fun setPresenter(presenter: ProfileContract.Presenter) {
        this.presenter = presenter
    }

    override fun navigateToActivity(activity: KClass<out Activity>) {
        TODO("Not yet implemented")
    }


}