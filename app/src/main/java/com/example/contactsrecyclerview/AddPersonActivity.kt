package com.example.contactsrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText



class AddPersonActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "AddPersonActivity"
    }

    private val btnSave : Button by lazy {
        findViewById(R.id.btnSave)
    }

    private val etPersonName : EditText by lazy {
        findViewById(R.id.etPersonName)
    }

    private val etAge : EditText by lazy {
        findViewById(R.id.etAge)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        btnSave.setOnClickListener() {
            val newPersonName = etPersonName.text
            val newPersonAge = etAge.text.toString()

            Log.i(TAG, "NewPersonName = $newPersonName, $newPersonAge")
        }

    }
}