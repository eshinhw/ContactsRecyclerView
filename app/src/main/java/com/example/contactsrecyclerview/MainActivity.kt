package com.example.contactsrecyclerview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val KEY_PERSON = "person"

class MainActivity : AppCompatActivity() {

    companion object { // replacement of static
        // In Java, private static final
        private const val TAG = "MainActivity"
        private const val REQUEST_CODE = 200
    }
    private val rvContacts: RecyclerView by lazy {
        findViewById(R.id.rvContacts)
    }

    // var contactsList = mutableListOf<Person>() // define contactsList an empty list with val
    private lateinit var contactsList : MutableList<Person> // just declare contactsList as MutableList<Person>
    // lateinit guarantees that we are going to assign value to contactsList later on

    private lateinit var contactsAdapter: ContactsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        contactsList = createContacts()

        // set layoutManager
        rvContacts.layoutManager = LinearLayoutManager(this)

        // set adapter
        contactsAdapter = ContactsAdapter(this, contactsList)
        rvContacts.adapter = contactsAdapter
        

        //
    }

    private fun createContacts(): MutableList<Person> {

        val contacts: MutableList<Person> = mutableListOf<Person>()
        for (i in 1..100) {
            contacts.add(Person("Person $i", i))
        }
        return contacts
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(TAG, "onOptionsItemSelected")
        if (item.itemId == R.id.miAdd) {
            val intent = Intent(this, AddPersonActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE) // we want to get the data back from this intent
            return true // we return true because we have consumed the click button
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // We got the data back successfully from AddPersonActivity
            val person = data?.getSerializableExtra(KEY_PERSON) as Person
            contactsList.add(5,person)


            // data is nullable type Nullability Check

            /*
            val bad: String = null // compiler error!
            val name: String? = null // ok

             */

            contactsAdapter.notifyDataSetChanged()
        }


        super.onActivityResult(requestCode, resultCode, data)
    }


}