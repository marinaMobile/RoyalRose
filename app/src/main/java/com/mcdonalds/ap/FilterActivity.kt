package com.mcdonalds.ap

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.*

class FilterActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_filter)
            val txtEr: TextView = findViewById(R.id.inviteTxt)
            runBlocking {

                val job: Job = GlobalScope.launch(Dispatchers.IO) {
                    getAsync(applicationContext)
                }
                job.join()
                val jsoup: String? = Hawk.get(Constant.asyncResult, "")
                Log.d("cora", "cora $jsoup")

                txtEr.text = jsoup

                if (jsoup == "o9Bd") {
                    Intent(applicationContext, GamerActivity::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, FilActivity::class.java).also { startActivity(it) }
                }
                finish()
            }
        }
        private suspend fun getAsync(context: Context) {
            val asyncKey = JSo(context)
            val asyncResult = asyncKey.getDocSecretKey()
            Hawk.put(Constant.asyncResult, asyncResult)
        }
    }
