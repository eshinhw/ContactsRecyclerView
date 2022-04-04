package com.example.contactsrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }
    private val rvContacts: RecyclerView by lazy {
        findViewById(R.id.rvContacts)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val userContacts = createContacts()

        // set layoutManager
        rvContacts.layoutManager = LinearLayoutManager(this)

        // set adapter
        rvContacts.adapter = ContactsAdapter(this, userContacts)
        

        //
    }

    private fun createContacts(): List<Person> {

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
            startActivity(intent)
            return true // we return true because we have consumed the click button
        }
        return super.onOptionsItemSelected(item)
    }


}