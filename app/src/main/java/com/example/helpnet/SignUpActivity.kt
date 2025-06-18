package com.example.helpnet



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var editTextFullName: EditText
    private lateinit var editTextEmailPhone: EditText
    private lateinit var editTextPasswordSignUp: EditText
    private lateinit var editTextConfirmPassword: EditText
    private lateinit var buttonSignUp: Button
    private lateinit var textViewAlreadyAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        editTextFullName = findViewById(R.id.editTextFullName)
        editTextEmailPhone = findViewById(R.id.editTextEmailPhone)
        editTextPasswordSignUp = findViewById(R.id.editTextPasswordSignUp)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
        buttonSignUp = findViewById(R.id.buttonSignUp)
        textViewAlreadyAccount = findViewById(R.id.textViewAlreadyAccount)

        buttonSignUp.setOnClickListener {
            val name = editTextFullName.text.toString()
            val emailPhone = editTextEmailPhone.text.toString()
            val password = editTextPasswordSignUp.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()

            if (name.isEmpty() || emailPhone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Account Created Successfully!", Toast.LENGTH_SHORT).show()
                // You can now save user info or move to login screen
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        textViewAlreadyAccount.setOnClickListener {
            // Navigate back to login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
