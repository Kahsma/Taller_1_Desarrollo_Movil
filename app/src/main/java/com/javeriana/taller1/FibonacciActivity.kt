package com.javeriana.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javeriana.taller1.databinding.ActivityFibonacciBinding

class FibonacciActivity : AppCompatActivity() {
    private var factorialCounter = 0
    private var fibonacciCounter = 0
    private var lastFactorialTime = ""
    private var lastFibonacciTime = ""
    private lateinit var binding: ActivityFibonacciBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_fibonacci)
        lBinding()

    }



    private fun lBinding (){
        binding = ActivityFibonacciBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textfibonacci.text = fibonacci(Integer.parseInt(intent.getStringExtra("NumeroOperar")))
    }

    fun fibonacci(n: Int): String {

        if (n == 1) {
            return "0"
        }
        if (n == 2) {
            return "0 -> 1"
        }
        val fib = mutableListOf(0, 1)
        var fibString = "0 -> 1"
        for (i in 2 until n) {
            fib.add(fib[i-1] + fib[i-2])
            fibString += " -> ${fib.last()}"
        }
        return fibString
    }
}