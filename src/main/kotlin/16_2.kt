package murad

data class Student(val name: String, val age: Int, val averageGrade: Double, val missedClasses: Int)
val students = sequenceOf(
    Student("Алексей", 20, 85.0, 2),
    Student("Борис", 21, 88.0, 0),
    Student("Василий", 19, 90.0, 3),
    Student("Григорий", 22, 87.0, 1),
    Student("Дмитрий", 20, 89.0, 0),
    Student("Евгений", 21, 91.0, 2),
    Student("Федор", 19, 92.0, 1),
    Student("Георгий", 22, 88.0, 3),
    Student("Иван", 20, 90.0, 0),
    Student("Константин", 21, 89.0, 2)
)
fun main() {


    val sortedStudents = students.sortedByDescending { it.averageGrade }
    println("Студенты отсортированы по среднему баллу в порядке убывания:")
    sortedStudents.forEach { println("${it.name}: ${it.averageGrade}") }

    val averageAge = sortedStudents.map { it.age }.average()
    println("Средний возраст студентов: $averageAge")

    val studentsOver20 = sortedStudents.takeWhile { it.age > 20 }
    println("Студенты старше 20 лет:")
    studentsOver20.forEach { println("${it.name}: ${it.age}") }

    val bestStudent = sortedStudents.find { it.averageGrade == sortedStudents.maxOf { student -> student.averageGrade } }
    println("Студент с максимальным средним баллом: ${bestStudent?.name} с средним баллом ${bestStudent?.averageGrade}")
}