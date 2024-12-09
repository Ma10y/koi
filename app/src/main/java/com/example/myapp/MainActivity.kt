package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Activity binding object to avoid using 'findViewById'
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // calling button via binding with id with the pattern of 'binding.element_id'
        binding.button.setOnClickListener {

            // calling create function from SecondActivity and passing values from text fields
            SecondActivity.create(
                this,
                binding.name.text.toString(),
                binding.surname.text.toString(),
                binding.age.text.toString().toInt(),
                binding.weight.text.toString().toInt(),
                binding.height.text.toString().toInt()
            )
        }
    }
}