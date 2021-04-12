package com.niranjan.mycoolapp.model

class School(private val studentList: List<Students>) {
    fun printStudents(){
        studentList.forEach {
            println("Students Id:${it.id} - Student Name: ${it.name}")
        }
    }
}

class MySchool{
    val studentList = Provider.getStudentList()
    fun printStudents(){
        studentList.forEach {
            println("Students Id:${it.id} - Student Name: ${it.name}")
        }
    }
}

object Provider {
    fun getStudentList() = listOf<Students>(
            Students()
    )
}

fun main(args: Array<String>){
    val sList = listOf<Students>(
            Students("Ram",1),
            Students("Sita",2),
            Students("Laxman",3),
    )

    val school = School(sList)
    school.printStudents()

    val mySchool = MySchool()
    mySchool.printStudents()
    
}