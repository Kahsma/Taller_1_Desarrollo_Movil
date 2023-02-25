package com.javeriana.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.javeriana.taller1.databinding.ActivityFactorialBinding

class FactorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFactorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_factorial)
        lBinding()
        logicaPantalla()



    }

    private fun lBinding(){
        binding = ActivityFactorialBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun logicaPantalla(){
        val numero:Int = Integer.parseInt(intent.getStringExtra("NumeroOperar"))
        Log.v("nOperar",numero.toString())
        binding.textOperacion.text= "OPERACION: ${factorialString(numero)}"
        binding.textResultado.text= "RESULTADO: ${factorial(numero)}"
    }

    private fun factorial(n: Int): Int {
        var result = 1
        for (i in 2..n) {
            result *= i
        }
        return result
    }

    private fun factorialString(n: Int): String {
        var result = 1
        var str = "1"
        for (i in 2..n) {
            result *= i
            str += " * $i"
        }
        return str
    }

}