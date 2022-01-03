package com.example.myfirstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.startActivityForResult
//import com.example.myfirstapp.databinding.ActivityMainBinding
//
//private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Find View By id
        //setContentView(R.layout.activity_main) // Associate set of view to the screen
//        val helloText = findViewById<TextView>(R.id.hello_text)
//        helloText.text = "Hello Neha"
        // Accessing views using view Binding
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//        binding.helloText.text = "Hello Sheikh"



//        setContentView(R.layout.activity_main)
//        findViewById<android.widget.Button>(R.id.add_details_button).setOnClickListener{
//            val intent = android.content.Intent(
//                this,
//                UpdateActivity::class.java
//            )
//            startActivity(intent)
//        }
        setContentView(R.layout.activity_main)

        val nameTextView = findViewById<TextView>(R.id.name_text)
        val phoneTextView = findViewById<TextView>(R.id.phone_text)
        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
                result: ActivityResult ->
            if(result.resultCode == Activity.RESULT_OK) {
                result.data?.let{
                      val name = it.getStringExtra("name")
                      val phone = it.getStringExtra("phone")
                    nameTextView.text = name
                    phoneTextView.text = phone

                }
            }
        }
        findViewById<Button>(R.id.add_details_button).setOnClickListener{
            startForResult.launch(
                Intent(this,UpdateActivity::class.java
                )
            )
        }

    }
}