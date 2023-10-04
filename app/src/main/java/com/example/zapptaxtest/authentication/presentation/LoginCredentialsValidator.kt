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
            showError(emailErrorText, "L'adresse e-mail ne peut pas être vide")
            isValid = false
        }
        if (password.isEmpty()) {
            showError(passwordErrorText, "Le mot de passe ne peut pas être vide")
            isValid = false
        }
        if (email != "android@zapptax.com" || password != "ZappTax") {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                showError(emailErrorText, "E-mail invalide")
                showError(passwordErrorText, "Mot de passe invalide")
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
