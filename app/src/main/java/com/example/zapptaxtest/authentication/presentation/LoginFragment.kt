package com.example.zapptaxtest.authentication.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.zapptaxtest.MainActivity
import com.example.zapptaxtest.R
import com.example.zapptaxtest.databinding.FragmentLoginBinding
import com.example.zapptaxtest.databinding.IncludePasswordInputLayoutBinding
import com.example.zapptaxtest.databinding.IncludeTextInputLayoutBinding
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val credentialsValidator = LoginCredentialsValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNavigateToMainActivity.setOnClickListener {

            val email = binding.emailEditText.textLayout.editText?.text.toString()
            val password = binding.passwordEditText.textLayout.editText?.text.toString()
            val emailErrorText=binding.emailErrorTextView
            val passwordErrorText=binding.passwordErrorTextView

            if (credentialsValidator.validateCredentials(emailErrorText, passwordErrorText, email, password)) {
                navigateToMainActivity()
            }
        }
    }
    private fun navigateToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }
}