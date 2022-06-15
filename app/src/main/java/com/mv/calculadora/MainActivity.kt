package com.mv.calculadora

import Mundo.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operacion = findViewById<TextView>(R.id.text_operation_main)
        var resultado = findViewById<TextView>(R.id.text_result_main)
        var num0 = findViewById<Button>(R.id.button_0_main)
        var num1 = findViewById<Button>(R.id.button_1_main)
        var num2 = findViewById<Button>(R.id.button_2_main)
        var num3 = findViewById<Button>(R.id.button_3_main)
        var num4 = findViewById<Button>(R.id.button_4_main)
        var num5 = findViewById<Button>(R.id.button_5_main)
        var num6 = findViewById<Button>(R.id.button_6_main)
        var num7 = findViewById<Button>(R.id.button_7_main)
        var num8 = findViewById<Button>(R.id.button_8_main)
        var num9 = findViewById<Button>(R.id.button_9_main)
        var suma = findViewById<Button>(R.id.button_suma_main)
        var resta = findViewById<Button>(R.id.button_resta_main)
        var multiplicacion = findViewById<Button>(R.id.button_factor_main)
        var division = findViewById<Button>(R.id.button_division_main)
        var igual = findViewById<Button>(R.id.button_igual_main)
        var reiniciar = findViewById<Button>(R.id.button_c_main)

        num0.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}0"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num1.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}1"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num2.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}2"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num3.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}3"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num4.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}4"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num5.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}5"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num6.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}6"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num7.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}7"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num8.setOnClickListener {
            try {
                operacion.text =  "${operacion.text}8"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        num9.setOnClickListener {
            try {
                operacion.text = "${operacion.text}9"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        suma.setOnClickListener {
            try {
                operacion.text = "${operacion.text}+"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        resta.setOnClickListener {
            try {
                operacion.text = "${operacion.text}-"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        multiplicacion.setOnClickListener {
            try {
                operacion.text = "${operacion.text}x"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        division.setOnClickListener {
            try {
                operacion.text = "${operacion.text}÷"
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        igual.setOnClickListener {
            try {
                val op = operacion.text.toString()
                if (op.isEmpty()) throw Exception("Debe ingresar un valor")
                resultado.text = calcular(op).toString()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        reiniciar.setOnClickListener {
            try {
                resultado.text =  ""
                operacion.text =  ""
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }
}