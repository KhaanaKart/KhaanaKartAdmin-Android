package com.example.khaanakartadmin

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.khaanakartadmin.databinding.ActivityAddMenuItemsBinding

class AddMenuItemsActivity : AppCompatActivity() {

    private val cameraResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        result.data?.let { intent ->
            val bitmap: Bitmap? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("data", Bitmap::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra("data")
            }

            bitmap?.let {
                binding.foodImageView.setImageBitmap(bitmap)
            } ?: run {
                binding.foodImageView.setImageResource(R.drawable.placeholder_image)
            }
        } ?: run {
            binding.foodImageView.setImageResource(R.drawable.placeholder_image)
        }
    }

    private val galleryResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        result.data?.data?.let { uri ->
            try {
                val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                binding.foodImageView.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
                binding.foodImageView.setImageResource(R.drawable.placeholder_image)
            }
        } ?: run {
            binding.foodImageView.setImageResource(R.drawable.placeholder_image)
        }
    }

    private val binding: ActivityAddMenuItemsBinding by lazy {
        ActivityAddMenuItemsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.cameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraResultLauncher.launch(intent)
        }

        binding.galleryButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryResultLauncher.launch(intent)
        }

        binding.backButton.setOnClickListener {
            this.finish()
        }
    }
}