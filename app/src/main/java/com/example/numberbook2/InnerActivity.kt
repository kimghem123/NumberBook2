package com.example.numberbook2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inner.*

class InnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inner)
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phoneNum")
        InnerName.setText(name)
        InnerPhoneNumber.setText(phone)
    }
}