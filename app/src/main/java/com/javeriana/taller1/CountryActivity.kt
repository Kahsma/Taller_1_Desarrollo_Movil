package com.javeriana.taller1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javeriana.taller1.databinding.ActivityCountryBinding
import com.javeriana.taller1.pojos.Paises




class CountryActivity : AppCompatActivity() {
    lateinit var pais:Paises
    private lateinit var lPaises: ArrayList<Paises>
    private lateinit var binding: ActivityCountryBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_country)
        pais = intent.getSerializableExtra("pais") as Paises
        lBinding()
    }

    private fun lBinding(){
        binding = ActivityCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val countryObject = buscarPais()





        binding.textCapital.text = pais.capital
        binding.textNomPais.text = pais.nombrePais
        binding.textSigla.text = pais.sigla
        binding.textNomInt.text = pais.nombrePaisInt

    }

//    private fun loadCountries() : String{
//        var json : String
//        var istr : InputStream = this.assets.open("paises.json")
//        val size = istr.available()
//        val byteArray = ByteArray(size)
//        istr.read(byteArray)
//        istr.close()
//        json = String(byteArray, Charset.defaultCharset())
//        return json
//    }
//
//    private fun buscarPais():Paises{
//        lPaises = ArrayList<Paises>()
//        val countryObject = Paises()
//        val jsonObject = JSONObject(loadCountries())
//        var arrayCountries = jsonObject.getJSONArray("paises")
//        for (i in 0 until arrayCountries.length()){
//            val country = arrayCountries.getJSONObject(i)
//
//
//            countryObject.capital = country.getString("capital")
//            countryObject.nombrePais = country.getString("nombre_pais")
//            countryObject.nombrePaisInt = country.getString("nombre_pais_int")
//            countryObject.sigla = country.getString("sigla")
//
//            if(countryObject.capital.equals(intent.getStringExtra("pais").toString() )){
//                return countryObject
//                i=arrayCountries.length()+1
//                break
//
//
//            }
//        }
//        return countryObject
//    }
//

}