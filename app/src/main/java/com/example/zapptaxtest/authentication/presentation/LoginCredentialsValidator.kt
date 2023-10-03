package com.example.zapptaxtest.authentication.presentation

import android.view.View
import android.widget.TextView

class LoginCredentialsValidator {
    fun validateCredentials(
        emailErrorText: TextView,
        passwordErrorText: TextView,
        email: String,
        password: String
    ) :Boolean{
        var isValid = true
        hideError(emailErrorText)
        hideError(passwordErrorText)
        if (email.isEmpty()) {
            showError(emailErrorText, "Email cannot be empty")
            isValid = false
        }
        if (password.isEmpty()) {
            showError(passwordErrorText, "Password cannot be empty")
            isValid = false
        }
        if (email != "android@zapptax.com" || password != "ZappTax") {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                showError(emailErrorText, "Invalid email")
                showError(passwordErrorText, "Invalid password")
            }
            isValid = false
        }

        return isValid
    }

    private fun showError(errorTextView: TextView, message: String) {
        errorTextView.text = message
        errorTextView.visibility = View.VISIBLE
    }

    private fun hideError(errorTextView: TextView) {
        errorTextView.text = ""
        errorTextView.visibility = View.GONE
    }
}
