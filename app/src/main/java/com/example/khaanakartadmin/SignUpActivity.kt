package com.example.khaanakartadmin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khaanakartadmin.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.alreadyHaveAccButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.signUpButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val locationList: Array<String> = arrayOf("Noida", "Greater Noida", "New Delhi", "Gurugram", "Faridabad", "Ghaziabad")
        val adapter = ArrayAdapter(this, R.layout.dropdown_list_item, locationList)
        val autoCompleteTextView = binding.autoCompleteLocationList
        autoCompleteTextView.setAdapter(adapter)
    }
}