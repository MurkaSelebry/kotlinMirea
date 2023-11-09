package testing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Модульные тесты для класса [Student].
 */
internal class StudentTest {


    /**
     * Тест метода [addGrade] с недопустимой оценкой, который должен вызвать исключение [IllegalArgumentException].
     */
    @Test
    fun `addGrade с недопустимой оценкой должен вызвать IllegalArgumentException`() {
        // Arrange
        val student = Student("John")

        // Act, Assert
        assertThrows(IllegalArgumentException::class.java) {
            student.addGrade(110)
        }
    }

    /**
     * Тест метода [addGrade] с допустимой оценкой, который должен добавить оценку в список оценок.
     */
    @Test
    fun `addGrade с допустимой оценкой должен добавить оценку в список оценок`() {
        // Arrange
        val student = Student("John")

        // Act
        student.addGrade(90)

        // Assert
        assertEquals(1, student.getGradeCount())
        assertEquals(90, student.grades[0])
    }

    /**
     * Тест метода [calculateAverageGrade] без оценок, который должен вернуть ноль.
     */
    @Test
    fun `calculateAverageGrade без оценок должен вернуть ноль`() {
        // Arrange
        val student = Student("John")

        // Act
        val average = student.calculateAverageGrade()

        // Assert
        assertEquals(0.0, average)
    }

    /**
     * Тест метода [calculateAverageGrade] с допустимыми оценками, который должен вычислить средний балл.
     */
    @Test
    fun `calculateAverageGrade с допустимыми оценками должен вычислить средний балл`() {
        // Arrange
        val student = Student("John")
        student.addGrade(90)
        student.addGrade(80)

        // Act
        val average = student.calculateAverageGrade()

        // Assert
        assertEquals(85.0, average)
    }

    /**
     * Тест метода [getGradeCount], который должен вернуть количество добавленных оценок.
     */
    @Test
    fun `getGradeCount должен вернуть количество добавленных оценок`() {
        // Arrange
        val student = Student("John")
        student.addGrade(90)
        student.addGrade(80)

        // Act
        val gradeCount = student.getGradeCount()

        // Assert
        assertEquals(2, gradeCount)
    }

    /**
     * Тест метода [isHonorStudent] с средним баллом ниже 90, который должен вернуть false.
     */
    @Test
    fun `isHonorStudent с средним баллом ниже 90 должен вернуть false`() {
        // Arrange
        val student = Student("John")
        student.addGrade(80)
        student.addGrade(85)

        // Act
        val isHonor = student.isHonorStudent()

        // Assert
        assertFalse(isHonor)
    }

    /**
     * Тест метода [isHonorStudent] с средним баллом равным 90, который должен вернуть true.
     */
    @Test
    fun `isHonorStudent с средним баллом равным 90 должен вернуть true`() {
        // Arrange
        val student = Student("John")
        student.addGrade(90)
        student.addGrade(90)

        // Act
        val isHonor = student.isHonorStudent()

        // Assert
        assertTrue(isHonor)
    }

    /**
     * Тест метода [isHonorStudent] с средним баллом выше 90, который должен вернуть true.
     */
    @Test
    fun `isHonorStudent с средним баллом выше 90 должен вернуть true`() {
        // Arrange
        val student = Student("John")
        student.addGrade(95)
        student.addGrade(92)

        // Act
        val isHonor = student.isHonorStudent()

        // Assert
        assertTrue(isHonor)
    }


    /**
     * Тест метода [getName], который должен вернуть имя студента.
     */
    @Test
    fun `getName должен вернуть имя студента`() {
        // Arrange
        val student = Student("John")

        // Act
        val name = student.getName()

        // Assert
        assertEquals("John", name)
    }
}
