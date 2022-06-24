package com.mcdonalds.ap

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_gamer.*
import kotlinx.coroutines.*

class GamerActivity : AppCompatActivity() {
    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamer)
        val myDialog = DialogWindow()
        val manager = supportFragmentManager

        myDialog.show(manager, "this")
        rainAnim.setOnClickListener{

                rainAnim.playAnimation()
                rainAnim.addAnimatorListener(object: Animator.AnimatorListener{
                    override fun onAnimationStart(p0: Animator?) {
                        TODO("Not yet implemented")
                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        TODO("Not yet implemented")
                    }

                    override fun onAnimationCancel(p0: Animator?) {
                        TODO("Not yet implemented")
                    }

                    override fun onAnimationRepeat(p0: Animator?) {

                        if(score > 1) {
                            Log.d("Co","Outside Log")
                            roseAnimation.playAnimation()
                            winner_text.visibility = View.VISIBLE

                            lifecycleScope.launch(Dispatchers.Default){
                                test()
                            }

                       } else {
                           score++
                       }

//
                    }
                })

        }
    }
    suspend fun test() {
        withContext(Dispatchers.Default) {
            delay(10000L)
            //Log.d("Co", "This is Thread:" + Thread.currentThread().name + "thats being called")
           startActivity(Intent(this@GamerActivity, FinalAct::class.java))
            finish()

        }
    }
    }



