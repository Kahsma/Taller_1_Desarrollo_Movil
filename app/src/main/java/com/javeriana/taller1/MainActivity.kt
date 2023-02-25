package com.javeriana.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import com.javeriana.taller1.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private  var factorialCounter = 0
    private var fibonacciCounter = 0
    private var lastFactorialTime = ""
    private var lastFibonacciTime = ""


    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        bindingGeneral();

    }

    private fun bindingGeneral(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intentGG()
        intentGreet()
        intentFact()
        intentFibonacci()





    }

    override fun onPause() {
        super.onPause()


    }

    override fun onResume() {
        super.onResume()

        val counterText = "Factorial: $factorialCounter  $lastFactorialTime\nFibonacci: $fibonacciCounter  $lastFibonacciTime"
        binding.textAccesos.text = counterText
    }
    private fun intentGG(){

        binding.ggB.setOnClickListener {

            if(binding.editTextUpperLimitGG.text.toString().trim().isEmpty()||Integer.parseInt(binding.editTextUpperLimitGG.text.toString())<0||Integer.parseInt(binding.editTextUpperLimitGG.text.toString())>1000){
                binding.editTextUpperLimitGG.error = "Numero invalido "

                //Toast.makeText(baseContext,"Numero invalido",Toast.LENGTH_SHORT).show()
                return@setOnClickListener;
            }
            startActivity(Intent(baseContext, GuessGameActivity::class.java).apply {
                putExtra("Prompt", binding.editTextUpperLimitGG.text.toString())
            })
        }

    }

    private fun intentGreet(){
        binding.rgB.setOnClickListener {
            startActivity(Intent(baseContext,GreetActivity::class.java).apply {
                putExtra("IndiceL",binding.spinnerLanguage.selectedItemPosition.toString())
                Log.v("IndiceL", binding.spinnerLanguage.selectedItemPosition.toString())
            })
        }

    }
    private fun intentFact(){
        binding.factorialB.setOnClickListener {
            if (binding.editTextFact.text.toString().trim().isEmpty()){
                binding.editTextFact.error="Inserte un numero!"

            return@setOnClickListener}
            factorialCounter++
            lastFactorialTime = "Last Factorial used: " + Date().toString()
            startActivity(Intent(baseContext,FactorialActivity::class.java).apply {
                putExtra("NumeroOperar",binding.editTextFact.text.toString())


            })

        }


    }

    private fun intentFibonacci(){



        binding.fibonacciButton.setOnClickListener {
            if (binding.editTextFact.text.toString().trim().isEmpty()){
                binding.editTextFact.error="Inserte un numero!"

                return@setOnClickListener}
            fibonacciCounter++
            lastFibonacciTime = "Last Fibonacci used: " + Date().toString()
            startActivity(Intent(baseContext,FibonacciActivity::class.java).apply {
                putExtra("NumeroOperar",binding.editTextFact.text.toString())


            })


        }
    }
}