package com.niranjan.tutorials.basics


fun main() {
    // Data Type
    val immutable_data = 2
    val mutable_data = ""

    // Collections
    val immutable_collection = listOf<String>("a", "b", "c")
    var mutable_collection = hashSetOf<Int>(1, 2, 3)

    immutable_collection.forEach {
        print(it+"-")
        print("\n")
    }
    mutable_collection.plusElement(4)
    mutable_collection.forEach {
        print(it.toString()+" @")
    }
}