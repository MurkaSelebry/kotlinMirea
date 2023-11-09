package testing
/**
 * Основная функция программы для взаимодействия с объектами класса [Student].
 * Программа позволяет добавлять студентов и их оценки, а также просматривать список студентов
 * с информацией о них.
 */
fun main() {
    val students = mutableListOf<Student>()

    while (true) {
        println("Меню:")
        println("1. Добавить студента и оценки")
        println("2. Показать список студентов")
        println("3. Выход")
        print("Выберите действие: ")

        when (readLine()) {
            "1" -> {
                println("Введите имя студента:")
                val name = readLine() ?: ""
                val student = Student(name)

                // Ввод количества оценок
                print("Введите количество оценок для студента $name: ")
                val numGrades = readLine()?.toIntOrNull() ?: 0

                if (numGrades <= 0) {
                    println("Некорректное количество оценок.")
                } else {
                    for (i in 1..numGrades) {
                        print("Введите оценку $i для студента $name: ")
                        val grade = readLine()?.toIntOrNull()

                        if (grade != null && grade in 0..100) {
                            student.addGrade(grade)
                        } else {
                            println("Некорректная оценка. Оценка должна быть в диапазоне от 0 до 100.")
                        }
                    }

                    students.add(student)
                    println("Добавлен студент: $name")
                }
            }
            "2" -> {
                if (students.isEmpty()) {
                    println("Список студентов пуст.")
                } else {
                    println("Список студентов:")
                    println("| Имя         | Оценки                | Средний балл | Отличник |")
                    println("|-------------|------------------------|--------------|----------|")

                    for (student in students) {
                        val averageGrade = student.calculateAverageGrade()
                        val gradeCount = student.getGradeCount()
                        val isHonorStudent = student.isHonorStudent()

                        // Формируем строку для вывода информации о студенте
                        val gradeString = student.grades.joinToString(", ")
                        val honorStatus = if (isHonorStudent) "Да" else "Нет"

                        println("| ${student.getName().padEnd(12)} | ${gradeString.padEnd(24)} | ${averageGrade.toString().padEnd(12)} | $honorStatus |")
                    }
                }
            }
            "3" -> {
                println("Выход из программы.")
                return
            }
            else -> println("Некорректный ввод. Пожалуйста, выберите действие из меню.")
        }
    }
}
