package com.niranjan.mycoolapp.kotlintut

import android.annotation.TargetApi
import androidx.annotation.experimental.Experimental

//
// Created by NIRANJAN KHATRI on 18/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//

const val TOP_CONSTANT = "TOP_CONSTANT"

class KotlinAdvance( val value : String) {

    // defining extension property
    val KotlinAdvance.isValid  : Boolean
        get() {
            return value != " "
        }


    companion object {
        const val INNER_CONST = "INNER_CONST"
    }

}

fun KotlinAdvance?.extensionFunction(input: String) : Boolean {
    this?.apply { return input.length> 1 }
    return false
}


object Object1 {
    const val OBJECT_CONSTANT = "OBJECT_CONSTANT"
}

fun main(){
    val pair = "one" to "1"
    println(pair.first)
    val chain = "a" to "b" to "c"
    println(chain)

    val equipment = "knife" to "cut"
    val (tool, use) = functionName("one")

    println(tool)

    var map = mapOf(1 to "one", 2 to "two")
    println("Map : ${map.size}")

    // collections
    val list = listOf(1,2,3,4,5,6,7,8,9)
    println("Reversed List : ${list.reversed()}")

    val mutableList = mutableListOf(2,3,5,6)
    println("before : $mutableList")
    val newlist = mutableList.subList(2,mutableList.size)
    println("after : $newlist")
    val wordList = mutableListOf("aòsldkfj", "lskdjf","jskdj")
    println("sum by chars : ${wordList.sumBy { it.length }}")

    val result = "laskdfjaslkdfjlsadkfj".isSpace()
    println("Result : $result")

}

fun functionName( input: String) : Pair<String, String> {
    return ("true " to "1")
}


fun String.isSpace() : Boolean {
    val found : Char? = this.find { it == ' ' }
    return found != null
}


fun nullableExample(){
    val advance : KotlinAdvance? = null
    advance.extensionFunction("sldkfj")
}





class GenericClass<T>{
    val list = mutableListOf<T>()

    fun set(item: T) { list.add(item)}
    fun get(index: Int) {list.get(index) }
}


class Apple( val name: String){}
class Ball{}
class Cat{}

fun genericUsecase(){
    val apples : GenericClass<Apple>? = null
    val balls : GenericClass<Ball>? = null
    val cats : GenericClass<Cat>? = null

    val apple = Apple("name")
    val ball = Ball()
    val cat = Cat()

    apples?.set(apple)
    balls?.set(ball)
    cats?.set(cat)

    val myapple = apples?.get(2)

    val value = GenericOut<Int>()

}

fun <T> genericFunc(){
    print("something")
}

class GenericOut<out T> : GenericIn<String>{
    override fun <T> doSomething() {
        val value = genericFunc<String>()
    }
}

interface GenericIn<in T>{
    fun <T> doSomething()
}






fun advanceUsecase(){

    val mutableList = mutableListOf<String>("apples", "carrots", "orange")
    val food = "rice"

    with(food){
        capitalize()
    }


    val result = mutableList.run {
        get(1)
    }
    // carrots

    val returnObject = mutableList.apply {
        add("mango")
    }
    // return mutablelist

    val list : MutableList<Int>? = null

    list?.let {  mutableList ->
        mutableList.add(1)
    }

    val value = "pump"

    value.let { it+ "k" }.let { it+ "ing" }.let { it+ "!" }

}


inline fun hofunction(name: String, input: (Int)-> Int ){
    
}



@TargetApi(21)
fun annnotationFunc(){

}
































