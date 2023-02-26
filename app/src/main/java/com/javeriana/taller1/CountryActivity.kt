package com.javeriana.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javeriana.taller1.databinding.ActivityCountryBinding
import com.javeriana.taller1.pojos.Paises

class CountryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_country)
    }
    private fun lBinding(){
        binding = ActivityCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pais = intent.getSerializableExtra("pais") as Paises
    }
}