package com.example.contactsrecyclerview

import android.app.Activity
import android.content.Intent
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
            val newPersonName = etPersonName.text.toString()
            val newPersonAge = etAge.text.toString().toInt()

            Log.i(TAG, "NewPersonName = $newPersonName, $newPersonAge")

            val person = Person(newPersonName, newPersonAge)

            // create another Intent to pass back the data to MainActivity

            val result = Intent(this, MainActivity::class.java)
            result.putExtra(KEY_PERSON, person) // key-value pair, key is always String, value is an object we are passing
            // we might have an error on putExtra because Person object is not offered in putExtra
            // we can use Serializable on data class Person to remove the error
            // Serializable is an empty interface --> There is nothing to do one our side
            // By extending Serializable --> we get all the benefits
            setResult(Activity.RESULT_OK, result) //
            finish() // we go back to MainActivity
        }

    }
}