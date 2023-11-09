package prac5

class Student {
    private var name: String = ""
    private var surname: String = ""
    private var grades: IntArray = IntArray(10)

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getSurname(): String {
        return surname
    }

    fun setSurname(surname: String) {
        this.surname = surname
    }

    fun getGrades(): IntArray {
        return grades
    }

    fun setGrades(grades: IntArray) {
        this.grades = grades
    }

    fun addGrade(grade: Int) {
        for (i in 0 until grades.size - 1) {
            grades[i] = grades[i + 1]
        }
        grades[grades.size - 1] = grade
    }

    fun calculateAverageGrade(): Double {
        var sum = 0
        for (grade in grades) {
            sum += grade
        }
        return sum.toDouble() / grades.size
    }
}

fun main(){
    val student = Student()
    student.setName("Name")
    student.setSurname("Sur")
    student.setGrades(intArrayOf(1,2,3,4,5,6,7,8,9,10))
    student.addGrade(5)
    println("${student.getName()} ${student.getSurname()} ${student.calculateAverageGrade()} \n${student.getGrades().contentToString()}")
}









