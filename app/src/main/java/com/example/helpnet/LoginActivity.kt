package com.example.helpnet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignIn: Button
    private lateinit var textViewSignUp: TextView
    private lateinit var textViewForgotPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSignIn = findViewById(R.id.buttonSignIn)
        textViewSignUp = findViewById(R.id.textViewSignUp)
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword)

        buttonSignIn.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Perform your login logic here
                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
                // Navigate to Home screen after login (example)
                val intent = Intent(this, MainActivity::class.java) // Change to MainActivity
                startActivity(intent)
                finish() // Close the LoginActivity
            }
        }

        textViewSignUp.setOnClickListener {
            // Navigate to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        textViewForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
            // Handle forgot password logic
        }
    }
}
