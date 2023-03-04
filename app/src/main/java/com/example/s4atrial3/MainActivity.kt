package com.example.s4atrial3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var beginjourney = findViewById<Button>(R.id.beginjourneybutton)
        beginjourney.setOnClickListener {
            var name : String = findViewById<EditText>(R.id.Nametextinput).text.toString()
            var vehicleID : String = findViewById<EditText>(R.id.VehicleIDtextinput).text.toString()

            var output = "$name  $vehicleID"
            Toast.makeText(this@MainActivity, output, LENGTH_LONG).show()
        }


    }
}