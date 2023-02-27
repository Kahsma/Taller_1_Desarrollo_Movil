package com.javeriana.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.javeriana.taller1.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private var factorialCounter = 0
    private var fibonacciCounter = 0
    private var guessGameCounter = 0
    private var countriesCounter =0
    private var randomGreetCounter = 0
    private var lastCountriesTime =""
    private var lastGuessGametime=""
    private var lastRandomGreetTime=""
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
        intentCountries()





    }

    override fun onPause() {
        super.onPause()


    }

    override fun onResume() {
        super.onResume()

        val counterText = "Guess:$guessGameCounter  $lastGuessGametime\nGreet:$randomGreetCounter  $lastRandomGreetTime\nCountries:$countriesCounter  $lastCountriesTime\nFactorial: $factorialCounter  $lastFactorialTime\nFibonacci: $fibonacciCounter  $lastFibonacciTime"
        binding.textAccesos.text = counterText
    }
    private fun intentGG(){

        binding.ggB.setOnClickListener {


            if(binding.editTextUpperLimitGG.text.toString().trim().isEmpty()||Integer.parseInt(binding.editTextUpperLimitGG.text.toString())<0||Integer.parseInt(binding.editTextUpperLimitGG.text.toString())>1000){
                binding.editTextUpperLimitGG.error = "Numero invalido "

                //Toast.makeText(baseContext,"Numero invalido",Toast.LENGTH_SHORT).show()
                return@setOnClickListener;
            }
            guessGameCounter++
            lastGuessGametime="Ultimo uso: " + Date().toString()
            startActivity(Intent(baseContext, GuessGameActivity::class.java).apply {
                putExtra("Prompt", binding.editTextUpperLimitGG.text.toString())
            })
        }

    }

    private fun intentGreet(){
        binding.rgB.setOnClickListener {
            randomGreetCounter++
            lastRandomGreetTime= "Ultimo uso: " + Date().toString()
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
            lastFactorialTime = "Ultimo Uso: " + Date().toString()
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
            lastFibonacciTime = "Ultimo Uso: " + Date().toString()
            startActivity(Intent(baseContext,FibonacciActivity::class.java).apply {
                putExtra("NumeroOperar",binding.editTextFact.text.toString())


            })


        }
    }
    private fun intentCountries(){


        binding.cB.setOnClickListener {
            countriesCounter++
            lastCountriesTime = "Ultimo Uso: " + Date().toString()
            startActivity(Intent(baseContext,CountryListActivity::class.java))
        }

    }
}