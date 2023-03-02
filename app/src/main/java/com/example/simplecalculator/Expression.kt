package com.example.simplecalculator

class Expression {
    var a=0
    var b=0
    var operator="+"
    private var result=0
    val value:Int
        get() {
            computeValue()
            return result
        }

    fun clearOperands() {
        a=0
        b=0
    }

    private fun computeValue() {
        result=0

        if (operator=="+")
            result= a+b
        else if (operator=="-")
            result= a-b
        else if (operator=="*")
            result= a*b
        else if (operator=="/" && b!=0)
            result= a/b
        else if (operator=="/" && b==0)
            result= a
        else
            result=  a%b

        clearOperands()
    }
}