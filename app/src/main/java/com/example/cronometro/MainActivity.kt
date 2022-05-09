package com.example.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputBinding
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
        var animButtonStart = AnimationUtils.loadAnimation(this, R.anim.button_start_down)
        binding.btStart.startAnimation(animButtonStart)

        var animButtonPause = AnimationUtils.loadAnimation(this, R.anim.button_pause_down)
        binding.btPause.startAnimation(animButtonPause)

        var animButtonStop = AnimationUtils.loadAnimation(this, R.anim.button_stop_down)
        binding.btStop.startAnimation(animButtonStop)
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