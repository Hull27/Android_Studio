package com.example.praktikum_app1

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val switchToRegister = view.findViewById<TextView>(R.id.switchToRegister)
        switchToRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.authFragmentContainer, RegisterFragment())
                .addToBackStack(null)
                .commit()
        }

        val loginButton = view.findViewById<Button>(R.id.loginButton)
        val emailEditText = view.findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email == "admin@gmail.com" && password == "123") {
                Toast.makeText(requireContext(), "Login Berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(requireContext(), MainActivity::class.java))
                activity?.finish()
            } else {
                Toast.makeText(requireContext(), "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
