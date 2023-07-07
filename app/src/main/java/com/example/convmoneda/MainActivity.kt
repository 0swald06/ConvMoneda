package com.example.convmoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.convmoneda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var moneda1:Spinner?=null
    private var moneda2:Spinner?=null
    private var valor:TextView?=null
    private var resultado:TextView?=null
    private lateinit var btnEnviar:Button
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
btnEnviar=findViewById(R.id.Enviar)
        moneda1=findViewById(R.id.moneda1)
        moneda2=findViewById(R.id.moneda2)
        valor= findViewById<View?>(R.id.valor) as TextView?
        resultado=findViewById(R.id.respuesta)
        Log.d("valor",valor.toString())
        val lista=arrayOf("USD","EUR","CLP" )
        var aux1:String=""
        var aux2:String=""
        var adaptador:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, lista)
        moneda1?.adapter=adaptador
        moneda2?.adapter=adaptador

        moneda1?.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               aux1= moneda1?.selectedItem.toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        moneda2?.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                aux2= moneda2?.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        btnEnviar.setOnClickListener {
            if (aux1=="USD" && aux2=="EUR"){
                if (valor?.text!=null){

                    var resul=convUSDtoEUR(valor?.text.toString().toDouble())
                    resultado.text= resul.toString()
                }else{
                    Toast.makeText(applicationContext, "Ingrese un valor", Toast.LENGTH_LONG)

                }


            }else if (aux1=="USD" && aux2=="CLP"){

                if (valor?.text!=null){

                    var resul=convUSDtoCLP(valor?.text.toString().toDouble()).toString()
                 resultado.text= resul
                }else{
                    Toast.makeText(applicationContext, "Ingrese un valor", Toast.LENGTH_LONG)

                }
            }else if (aux1=="CLP" && aux2=="EUR"){
                if (valor?.text!=null){

                    var resul=convCLPtoEUR(valor?.text.toString().toDouble()).toString()
                    resultado.text= resul
                }else{
                    Toast.makeText(applicationContext, "Ingrese un valor", Toast.LENGTH_LONG)

                }
            }else if (aux1=="CLP" && aux2=="USD"){
                if (valor?.text!=null){

                    var resul=convCLPtoUSD(valor?.text.toString().toDouble()).toString()
                    resultado.text= resul
                }else{
                    Toast.makeText(applicationContext, "Ingrese un valor", Toast.LENGTH_LONG)

                }
            }else if (aux1=="EUR" && aux2=="CLP"){
                if (valor?.text!=null){

                    var resul=convEURtoCLP(valor?.text.toString().toDouble()).toString()
                    resultado.text= resul
                }else{
                    Toast.makeText(applicationContext, "Ingrese un valor", Toast.LENGTH_LONG)

                }
            }else if (aux1=="EUR" && aux2=="USD"){
                if (valor?.text!=null){

                    var resul=convEURtoUSD(valor?.text.toString().toDouble()).toString()
                    resultado.text= resul
                }else{
                    Toast.makeText(applicationContext, "Ingrese un valor", Toast.LENGTH_LONG)

                }
            }else{

            }

        }

        }



        }
    fun convUSDtoEUR(valor:Double):Double{

        return valor*0.91

    }
    fun convUSDtoCLP(valor:Double):Double{

        return valor*804.30

    }
    fun convCLPtoUSD(valor:Double):Double{

        return valor/804.30

    }
    fun convCLPtoEUR(valor:Double):Double{

        return valor/875.82

    }
    fun convEURtoCLP(valor:Double):Double{

        return valor*875.82

    }
    fun convEURtoUSD(valor:Double):Double{

        return valor/0.91
    }
