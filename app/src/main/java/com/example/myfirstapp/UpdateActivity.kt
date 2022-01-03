package com.example.myfirstapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val nameEditText = findViewById<EditText>(R.id.name_edit)
        val phoneEditText = findViewById<EditText>(R.id.phone_edit)
        val saveButton = findViewById<Button>(R.id.save_button)

        saveButton.setOnClickListener{
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            intent.putExtra("name",name)
            intent.putExtra( "phone",phone)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}