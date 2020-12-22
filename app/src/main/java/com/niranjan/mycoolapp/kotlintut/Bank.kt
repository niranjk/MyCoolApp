package com.niranjan.mycoolapp.kotlintut

//
// Created by NIRANJAN KHATRI on 08/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//


class NameofClass() : OuterClass(){

    // properties
    private val immutable : String = "Private Value"
    public var mutable : Int = 123213

    private var object1 = PrivateClass()
    private var object2 = InnerClass()
    var object3 = ClasswithConstructor() // class with secondary empty constructor
    var object4 = ClasswithConstructor(23) // secondary non empty constructor
    var object5 = ClasswithConstructor(345, false) // primary constructor


    // method
    private fun method( property : Int) : Boolean {
        println(object1.x)
        println(object2.y)
        println(object5.property)
        return true
    }

}

private class PrivateClass(){

    var x: Int = 12

    private fun method(){
        x = 24
    }

}

open class OuterClass{

    protected var property : String = "laskdjf"
    protected class InnerClass{
        var y : Int = 123
    }
}

internal class InternalClass{

}

class ClasswithConstructor(var property: Int, notproperty: Boolean){

    var value : Int = 0
    // 1 or more secondary constructors

    constructor(z : Int):this(2, true){
        value = property
    }

    constructor(): this(23){
        value = property
    }

    // best practices while writing code.
    fun helperMethodToCreateConstructor() = ClasswithConstructor(property = 23, notproperty = false )

}


class InitBlockClass( value: Int) : Interface, Player() {

    var size : Int

    var singleton = SingletonClass

    // override var property: String = "New Value"

    init {
        // initalize first
        size = if (value > 2){ 10 }else { 20 }
    }

    constructor(): this(2){

    }

    override fun method1() {
        println("my internal implementation")
    }

    override fun method2() {
        println("my internal implementation2")
    }

    override var number: Int = 14

    override var color: String = "Blue"

    fun checkSealedClassType(sealed: SealedClass) : String{
        return  when(sealed){
            is One -> "It is Sealed One"
            is Two -> "It is Sealed Two"
            is Three -> "It is Sealed Three"
            is Four -> "It is Sealed Four"
        }
    }

    fun checkEnumClass(enumClass: EnumClass) : String{
        return  when(enumClass){
            EnumClass.BOTTOM -> "Bottom"
            EnumClass.LEFT -> "Left"
            EnumClass.RIGHT -> "Right"
            EnumClass.TOP -> "Top"
        }
    }

    fun checkMethodEnumClass(methodEnumClass: MethodEnumClass) : Boolean{
        return when(methodEnumClass){
            MethodEnumClass.BLUE_PARTY.method() -> true
            else -> false
        }
    }

}

open class SuperClass {
    open var property : String = "Value"
}

interface Interface {
    fun method1()
    fun method2()
}

abstract class Player {
    abstract var number : Int
    abstract var color : String
}


object SingletonClass {
    val property1 : Int = 12
    fun method12(): Boolean{
        return true
    }
}

data class Dataclass(
        val property: Int ,
        var property2: String = "default"
)

enum class EnumClass
{
    TOP,
    BOTTOM,
    LEFT,
    RIGHT
}

enum class MethodEnumClass
{
    RED_PARTY{
        override fun method() = RED_PARTY
    },

    BLUE_PARTY{
        override fun method() = BLUE_PARTY
    };

    abstract fun method(): MethodEnumClass
}


sealed class SealedClass

class One: SealedClass()
class Two: SealedClass()
class Three: SealedClass()
class Four: SealedClass()













