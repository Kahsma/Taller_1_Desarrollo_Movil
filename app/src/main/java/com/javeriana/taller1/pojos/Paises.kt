package com.javeriana.taller1.pojos


class Paises:java.io.Serializable  {
    lateinit var capital:String
    lateinit var nombrePais:String
    lateinit var nombrePaisInt:String
    lateinit var sigla:String
    override fun toString(): String {
        return nombrePais
        //return "Paises(capital='$capital', nombrePais='$nombrePais', nombrePaisInt='$nombrePaisInt', sigla='$sigla')"
    }


}


