package com.example.mobiotics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init(){

        encryption_btn.setOnClickListener {
            val intent = Intent(this, Encryption::class.java)
            intent.putExtra("title","Encryption")
            startActivity(intent)
        }

        decryption_btn.setOnClickListener {
            val intent = Intent(this, Decryption::class.java)
            intent.putExtra("title","Decryption")
            startActivity(intent)
        }

    }
}
