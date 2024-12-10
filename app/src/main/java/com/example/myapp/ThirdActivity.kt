package com.example.myapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.SecondActivity.Companion.ARG_AGE
import com.example.myapp.SecondActivity.Companion.ARG_HEIGHT
import com.example.myapp.SecondActivity.Companion.ARG_NAME
import com.example.myapp.SecondActivity.Companion.ARG_SURNAME
import com.example.myapp.SecondActivity.Companion.ARG_WEIGHT
import com.example.myapp.databinding.ActivitySecondBinding
import com.example.myapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private var type: String = ""
    private var duration: String = ""
    private var calories: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        val button: Button = findViewById(R.id.button7)
        button.setOnClickListener {
            val intent = Intent(this, SummaryActivity::class.java)
            startActivity(intent) }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        type = intent.getStringExtra(ARG_TYPE) ?: ""
       duration = intent.getStringExtra(ARG_DURATION) ?: ""
        calories = intent.getIntExtra(ARG_CALORIES,0)


    }
    companion object {
        const val ARG_TYPE = "ARG_NAME"
        const val ARG_DURATION = "ARG_SURNAME"
        const val ARG_CALORIES = "ARG_AGE"

        fun create(
            context: Context,
            type: String,
            duration: String,
            calories: Int,

            ) {
            val intent = Intent(context, SecondActivity::class.java)

            intent.putExtra(ARG_NAME, type)
            intent.putExtra(ARG_SURNAME, duration)
            intent.putExtra(ARG_AGE, calories)


            context.startActivity(intent)
        } }
}