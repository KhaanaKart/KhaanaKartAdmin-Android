package com.example.khaanakartadmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khaanakartadmin.databinding.ActivityCreateNewUserBinding

class CreateNewUserActivity : AppCompatActivity() {

    private val binding: ActivityCreateNewUserBinding by lazy {
        ActivityCreateNewUserBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            this.finish()
        }
    }
}