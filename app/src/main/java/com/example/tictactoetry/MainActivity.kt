package com.example.tictactoetry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.button)
        button.setBackgroundColor(getResources().getColor(R.color.deepblue))
        var et_name1:EditText=findViewById(R.id.et1)
        var et_name2:EditText=findViewById(R.id.et2)
        button.setOnClickListener{
            if(et_name1.text.isEmpty()||et_name2.text.isEmpty())
            {
                Toast.makeText(this,"Enter name of player first",Toast.LENGTH_LONG).show()
            }
            else
            {

                val intent= Intent(applicationContext,MainLayout::class.java) //for running activities
                intent.putExtra("player1",et_name1.text.toString())
                intent.putExtra("player2",et_name2.text.toString())
                startActivity(intent)

                finish()
            }

        }
        }

}