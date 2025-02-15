package com.example.testmobil2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.TextView)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        editText = findViewById(R.id.editTextText)

        // Обработчик нажатия на первую кнопку
        button.setOnClickListener {
            textView.text = "Expected Text After Click" // Изменяем текст в TextView
        }

        // Обработчик нажатия на вторую кнопку для перехода на вторую активность
        button2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
