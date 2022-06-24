package com.mcdonalds.ap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent

class FinalAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, GamerActivity::class.java))
    }
}