package com.example.calculatorkotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var x: Int = 5
    }

    fun buNumberEvent(view: View) {
        val EntryData = etShowNumber.text
        val buSelect = view as Button

        if (isNewOp) {
            etShowNumber.setText("")
        }
        isNewOp = false
        var buClickValue: String = etShowNumber.text.toString()
        when (buSelect.id) {
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
                buClickValue += "."
            }
            buPlusMinus.id -> {
                //todo :Prevent adding more than one dot
                buClickValue = "-" + buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true
    fun buOppEvent(view: View) {

        val buSelect = view as Button
        when (buSelect.id) {
            buMul.id -> {
                op = "*"
            }
            buDev.id -> {
                op = "/"
            }
            buMinus.id -> {
                op = "-"
            }
            buAdd.id -> {
                op = "+"
            }
        }
        oldNumber = etShowNumber.text.toString()
        isNewOp = true

        val toast = Toast.makeText(applicationContext, op, Toast.LENGTH_SHORT)
        toast.show()


    }

    fun buEqual(view: View) {
        val newNumber = etShowNumber.text.toString()
        var finalNo: Double? = null

        when (op) {
            "*" -> {
                finalNo = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNo = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNo = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNo = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNo.toString())
        isNewOp = true

    }
}
