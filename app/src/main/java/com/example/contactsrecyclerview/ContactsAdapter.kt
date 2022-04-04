package com.example.contactsrecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "ContactsAdapter"

class ContactsAdapter (val context: Context, val userContacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById<TextView>(R.id.personName)
        private val tvAge: TextView = itemView.findViewById<TextView>(R.id.personAge)

        fun bind(userContact: Person) {
            tvName.text = userContact.name
            tvAge.text = userContact.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder executed")
        val view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userContact = userContacts[position]
        Log.i(TAG, "before holder bind")
        holder.bind(userContact)
    }

    override fun getItemCount(): Int {
        return userContacts.size
    }
}