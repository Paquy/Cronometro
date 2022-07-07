package com.example.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.AnimationUtils
import com.example.cronometro.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private var running = false
var pause : Long = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
        animSetup()
    }
    private fun animSetup() {
        val animButtonStart = AnimationUtils.loadAnimation(this, R.anim.animate_buttons)
        binding.cvPlay.startAnimation(animButtonStart)

        val animButtonPause = AnimationUtils.loadAnimation(this, R.anim.animate_buttons)
        binding.cvPause.startAnimation(animButtonPause)

        val animButtonStop = AnimationUtils.loadAnimation(this, R.anim.animate_buttons)
        binding.cvReset.startAnimation(animButtonStop)
    }
    private fun setUp() {
        binding.btStart.setOnClickListener {
            startChronometer()
        }
        binding.btPause.setOnClickListener {
            pauseChronometer()
        }
        binding.btStop.setOnClickListener {
            stopChronometer()
        }
    }

    private fun stopChronometer(){
        if(running){
            binding.Temp.base = SystemClock.elapsedRealtime()
            pause = 0
            binding.Temp.stop()
            running = false
        }else{
            binding.Temp.base = SystemClock.elapsedRealtime()
            pause = 0
            binding.Temp.stop()
            running = false
        }
    }
    private fun startChronometer() {
        if(!running){
            binding.Temp.base = SystemClock.elapsedRealtime() - pause
            binding.Temp.start()
            running= true
        }
    }
    private fun pauseChronometer(){
        if(running){
            binding.Temp.stop()
            pause = SystemClock.elapsedRealtime() - binding.Temp.base
            running= false
        }
    }
}