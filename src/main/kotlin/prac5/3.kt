package prac5

import java.util.*

class StudentService{
    fun bestStudent(arr: Array<Student>): Student{
        val maxIndex = arr.indices.maxByOrNull { arr[it].calculateAverageGrade() }
        return arr[maxIndex!!]
    }
    fun sortBySurname(arr: Array<Student>){
        arr.sortBy { it.getSurname() }
    }
}

fun main(){
    val students = Array(5) { Student() }

    // Populate the student objects
    students[0].setName("Student2")
    students[0].setSurname("Surname2")
    students[0].setGrades(intArrayOf(1, 2, 3, 4, 5))

    students[1].setName("Student1")
    students[1].setSurname("Surname1")
    students[1].setGrades(intArrayOf(6, 7, 8, 9, 10))

    students[2].setName("Student3")
    students[2].setSurname("Surname3")
    students[2].setGrades(intArrayOf(3, 4, 6, 8, 9))

    students[3].setName("Student4")
    students[3].setSurname("Surname4")
    students[3].setGrades(intArrayOf(5, 5, 5, 5, 5))

    students[4].setName("Student5")
    students[4].setSurname("Surname5")
    students[4].setGrades(intArrayOf(10, 9, 8, 7, 6))

    for(s in students){
        println("${s.getSurname()}  ${s.calculateAverageGrade()}")
    }
    val sS = StudentService()
    println("Best student: ${sS.bestStudent(students).getSurname()}")
    sS.sortBySurname(students)
    for(s in students){
        println("${s.getSurname()}  ${s.calculateAverageGrade()}")
    }











}