package testing

/**
 * Класс, представляющий студента с именем и оценками.
 *
 * @property name Имя студента.
 * @property grades Список оценок студента.
 */
class Student(private val name: String) {
    val grades = mutableListOf<Int>()

    /**
     * Добавляет оценку студенту.
     *
     * @param grade Оценка, которую необходимо добавить.
     * @throws IllegalArgumentException Если оценка находится вне диапазона от 0 до 100.
     */
    fun addGrade(grade: Int) {
        require(grade in 0..100) { "Оценка должна быть в диапазоне от 0 до 100" }
        grades.add(grade)
    }

    /**
     * Вычисляет средний балл студента.
     *
     * @return Средний балл студента или 0.0, если студент не имеет оценок.
     */
    fun calculateAverageGrade(): Double {
        return if (grades.isEmpty()) 0.0 else grades.average()
    }

    /**
     * Получает количество оценок студента.
     *
     * @return Количество оценок студента.
     */
    fun getGradeCount(): Int {
        return grades.size
    }

    /**
     * Проверяет, является ли студент отличником.
     *
     * @return `true`, если средний балл студента равен или выше 90, иначе `false`.
     */
    fun isHonorStudent(): Boolean {
        val averageGrade = calculateAverageGrade()
        return averageGrade >= 90
    }

    /**
     * Получает имя студента.
     *
     * @return Имя студента.
     */
    fun getName(): String {
        return name
    }
}
