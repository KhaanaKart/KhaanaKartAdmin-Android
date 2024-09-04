package com.example.khaanakartadmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.khaanakartadmin.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private val binding: ActivityProfileBinding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.nameEditText.isEnabled = false
        binding.addressEditText.isEnabled = false
        binding.emailEditText.isEnabled = false
        binding.phoneEditText.isEnabled = false
        binding.passwordEditText.isEnabled = false

        binding.backButton.setOnClickListener {
            this.finish()
        }

        binding.editProfileButtonLayout.setOnClickListener {
            binding.nameEditText.isEnabled = true
            binding.addressEditText.isEnabled = true
            binding.emailEditText.isEnabled = true
            binding.phoneEditText.isEnabled = true
            binding.passwordEditText.isEnabled = true
        }
    }
}