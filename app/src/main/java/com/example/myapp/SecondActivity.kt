package com.example.myapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var name: String = ""
    private var surname: String = ""
    private var age: Int = 0
    private var weight: Int = 0
    private var height: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get values from intent to use it further
        name = intent.getStringExtra(ARG_NAME) ?: ""
        surname = intent.getStringExtra(ARG_SURNAME) ?: ""
        age = intent.getIntExtra(ARG_AGE,0)
        weight = intent.getIntExtra(ARG_WEIGHT,0)
        height = intent.getIntExtra(ARG_HEIGHT,0)

        //need to change using the previous example
        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent) }

    }

    //static functions and variables
    companion object {
        const val ARG_NAME = "ARG_NAME"
        const val ARG_SURNAME = "ARG_SURNAME"
        const val ARG_AGE = "ARG_AGE"
        const val ARG_WEIGHT = "ARG_WEIGHT"
        const val ARG_HEIGHT = "ARG_HEIGHT"

        fun create(
            context: Context,
            name: String,
            surname: String,
            age: Int,
            weight: Int,
            height: Int
        ) {
            val intent = Intent(context, SecondActivity::class.java)

            intent.putExtra(ARG_NAME, name)
            intent.putExtra(ARG_SURNAME, surname)
            intent.putExtra(ARG_AGE, age)
            intent.putExtra(ARG_WEIGHT, weight)
            intent.putExtra(ARG_HEIGHT, height)

            context.startActivity(intent)
        }
    }
}