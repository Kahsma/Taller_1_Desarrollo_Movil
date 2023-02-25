package com.javeriana.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.javeriana.taller1.databinding.ActivityGuessGameBinding
import kotlin.random.Random


class GuessGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuessGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_guess_game)


        lBinding()




    }

    private fun lBinding(){

        binding = ActivityGuessGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val str: String? =intent.getStringExtra("Prompt")
        var elContador = 0

        binding.textViewRango.text = """Guess a Number between 0 and $str"""



        val numeroAleatorio:Int =Random.nextInt(Integer.parseInt(str!!.trim()))
        Log.v("Random", numeroAleatorio.toString())

        binding.playButton.setOnClickListener {

            val elNumero = Integer.parseInt(binding.editRespuesta.text.toString() )
            if (elNumero < 0 || elNumero > Integer.parseInt(str.trim())){
                binding.editRespuesta.error = "El numero no obedece al rango"
                return@setOnClickListener
            }

            if(numeroAleatorio == elNumero ) {
                binding.textViewHint.text = "Bien Hecho!"
                binding.textViewRango.text = "=)"
                binding.textViewCounter.text= ":D"

            } else if (numeroAleatorio < elNumero ) {
                elContador++
                binding.textViewCounter.text = "Vas: $elContador Intentos!"
                binding.textViewHint.text = "el numero $elNumero es mayor "
            } else {
                elContador++
                binding.textViewCounter.text = "Vas: $elContador Intentos!"
                binding.textViewHint.text = "el numero $elNumero es menor "

            }

        }



    }

    fun crearNumeroA (){



    }
}