package com.javeriana.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javeriana.taller1.databinding.ActivityGreetBinding

class GreetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGreetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflaterG()




        //setContentView(R.layout.activity_greet)
    }

    private fun inflaterG(){
        binding = ActivityGreetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var lGreets = resources.getStringArray(R.array.greet)
        binding.greeting.text = lGreets[Integer.parseInt(intent.getStringExtra("IndiceL"))]

    }
}

