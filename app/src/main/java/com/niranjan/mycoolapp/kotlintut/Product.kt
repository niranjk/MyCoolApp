package com.niranjan.mycoolapp.kotlintut

//
// Created by NIRANJAN KHATRI on 07/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//
data class Product(
    var name: String? = null,
    var price: Int = 0
){

    fun sell(item: Int): Int{
        return item-1
    }

    fun buy(item: Int): Int{
        return item+1
    }
}


class Shop{

    var product : Product? = null

    var productList : List<Product> = listOf(
        Product("p1",1),
        Product("p2", 2)
    )

    var nullproductList : List<Product?> = listOf(null, null)
    var emptyProList : List<Product>? = null


    fun sellProduct( item: Int?){
        product!!.sell( item ?: 0)
    }

    fun cheapOrExpensive(product: Product){
        if (product.price > 20){
            println("the product is expensive")
        }else {
            println("the product is cheap")
        }
    }

    fun shouldITakeShower( temp: Int): Boolean {
        // body of function
        return when (temp){
            40 -> true
            else -> false
        }
    }

    fun takeShower ( temp: Int, dirt: Int, day: String): Boolean{
        return when{
            isTooHot(temp) -> true
            isDirty(dirt) -> true
            isSunday(day) -> true
            else -> false
        }
    }

    fun isTooHot(temp: Int) = temp > 40
    fun isDirty(dirt: Int) = dirt > 100
    fun isSunday(day: String) = day == "Sunday"



    var lambda = { input: Int -> input*34}
    fun higherOrderFunction ( x : Int, operation: (Int) -> Int): Int {
        return operation(x)
    }

    fun nameFunction( x: Int) = x + 10

    fun implement(){
        higherOrderFunction(23, lambda)
        higherOrderFunction(22, ::nameFunction)
    }


}

