package com.example.s4atrial3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        var beginjourney = findViewById<Button>(R.id.beginjourneybutton)
        beginjourney.setOnClickListener {
            var name: String = findViewById<EditText>(R.id.Nametextinput).text.toString()
            var vehicleID: String = findViewById<EditText>(R.id.VehicleIDtextinput).text.toString()
            var GPSCoordinates: String = findViewById<EditText>(R.id.GPSCoordinates).text.toString()

            var output = "$name  $vehicleID $GPSCoordinates"
            Toast.makeText(this@MainActivity, output, LENGTH_LONG).show()

            // Set up Firebase database emulator

            // Write a message to the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.reference.child("users").push()
            myRef.child("name").setValue(name)
            myRef.child("vehicleID").setValue(vehicleID)
            myRef.child("GPSCoordinates").setValue(GPSCoordinates)
        }
    }
}

