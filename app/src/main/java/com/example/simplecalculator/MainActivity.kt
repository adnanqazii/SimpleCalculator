package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private var display: TextView?=null
    private var expression:Expression?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display=findViewById(R.id.textView1) as TextView
        expression= Expression()


    }
    fun goOperand(view:View) {
        val value=display!!.text as String
        val digit=view.contentDescription as String
        if(value[0]=='0') {
            display!!.text=digit
        }
        else {
            display!!.text=display!!.text as String + digit
        }
    }
    fun goOperator(view: View) {
            val operator=view.contentDescription as String
        if (expression!!.a!=0) {
            computeValue(null)
        }
        saveA()
        display!!.text="0"
        expression!!.operator=operator
    }



    private fun saveA() {
        try {
            val value=display!!.text as String
            expression!!.a=value.toInt()
        }
        catch(e:NumberFormatException) {
            expression!!.a=0
        }

    }
    private fun saveB() {
        try {
            val value=display!!.text as String
            expression!!.b=value.toInt()
        }
        catch(e:NumberFormatException) {
            expression!!.b=0
        }

    }
    fun doAC(view: View) {
        expression!!.clearOperands()
        display!!.text="0"
    }
    fun computeValue(view: View?) {
        saveB()
        display!!.text=expression!!.value.toString()
    }
}
