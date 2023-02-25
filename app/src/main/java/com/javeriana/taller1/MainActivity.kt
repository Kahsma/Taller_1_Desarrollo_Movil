package com.javeriana.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.javeriana.taller1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        lBinding();

    }

    fun lBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ggB.setOnClickListener {

            if(binding.editTextUpperLimitGG.text.toString().trim().isEmpty()||Integer.parseInt(binding.editTextUpperLimitGG.text.toString())<0||Integer.parseInt(binding.editTextUpperLimitGG.text.toString())>1000){
                binding.editTextUpperLimitGG.error = "Numero invalido "

                //Toast.makeText(baseContext,"Numero invalido",Toast.LENGTH_SHORT).show()
                return@setOnClickListener;}

            startActivity(Intent(baseContext, GuessGameActivity::class.java).apply {
                putExtra("Prompt", binding.editTextUpperLimitGG.text.toString())



            })
        }






    }
}