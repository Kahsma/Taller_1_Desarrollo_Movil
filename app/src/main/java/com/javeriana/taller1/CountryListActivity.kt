package com.javeriana.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.javeriana.taller1.databinding.ActivityCountryListBinding
import com.javeriana.taller1.pojos.Paises
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

class CountryListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryListBinding
    private lateinit var lPaises: ArrayList<Paises>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_country_list)
        lBinding()


    }

    private fun lBinding(){
        binding = ActivityCountryListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadArray()
        //val adapter =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getNombrePaisList())
        val adapter =ArrayAdapter<Paises>(this,android.R.layout.simple_list_item_1,lPaises)
        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lPaises.map { it.nombrePais })
        binding.listView.adapter=adapter
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val selectedPais = lPaises[position]
            startActivity(Intent(baseContext,CountryActivity::class.java).apply {
                //put
                Log.v("NombreP",selectedPais.toString())
                putExtra("pais", selectedPais)
            })


        }


    }

    private fun loadCountries() : String{
        var json : String
        var istr : InputStream = this.assets.open("paises.json")
        val size = istr.available()
        val byteArray = ByteArray(size)
        istr.read(byteArray)
        istr.close()
        json = String(byteArray, Charset.defaultCharset())
        return json
    }

    private fun loadArray(){
        lPaises = ArrayList<Paises>()
        val jsonObject = JSONObject(loadCountries())
        var arrayCountries = jsonObject.getJSONArray("paises")
        for (i in 0 until arrayCountries.length()){
            val country = arrayCountries.getJSONObject(i)
            val countryObject = Paises()

            countryObject.capital = country.getString("capital")
            countryObject.nombrePais = country.getString("nombre_pais")
            countryObject.nombrePaisInt = country.getString("nombre_pais_int")
            countryObject.sigla = country.getString("sigla")

            lPaises.add(countryObject)
        }
    }

    private fun getNombrePaisList(): ArrayList<String> {
        val nombrePaisList = ArrayList<String>()
        val jsonObject = JSONObject(loadCountries())
        val arrayCountries = jsonObject.getJSONArray("paises")
        for (i in 0 until arrayCountries.length()) {
            val country = arrayCountries.getJSONObject(i)
            val pais = Paises().apply {
                capital = country.getString("capital")
                nombrePais = country.getString("nombre_pais")
                nombrePaisInt = country.getString("nombre_pais_int")
                sigla = country.getString("sigla")
            }
            lPaises.add(pais)
            nombrePaisList.add(pais.nombrePais)
        }
        return nombrePaisList
    }


}