package com.example.s4atrial3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object FirebaseUtil {
    fun useEmulator() {

    }

    class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up Firebase database emulator
        Firebase.database.useEmulator("10.0.2.2", 9000)

        // Add listener to the database reference
        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference.child("users")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method will be called whenever data is changed or added to the "users" child node in the database
                // Use snapshot.children to iterate over each child node, and extract relevant data as necessary
            }

            override fun onCancelled(error: DatabaseError) {
                // This method will be called if there is an error while trying to retrieve data from the database
            }
        })
    }

}}
