package prac10

import java.time.LocalDate
import java.time.format.DateTimeFormatter


enum class Gender {
    Male, Female
}

open class ValidationException(message: String) : IllegalAccessException(message)

class NameValidationException(message: String) : ValidationException(message)
class DateOfBirthValidationException(message: String) : ValidationException(message)
class GenderValidationException(message: String) : ValidationException(message)
class WeightValidationException(message: String) : ValidationException(message)

class FormValidator {
    fun validateName(name: String) {
        if (name.length < 2 || name.length > 20 || !name[0].isUpperCase()) {
            throw NameValidationException("Некорректное имя")
        }
    }


    fun validateDateOfBirth(dateOfBirth: LocalDate) {
        val currentDate = LocalDate.now()
        val minDate = LocalDate.of(1900, 1, 1)

        if (dateOfBirth.isBefore(minDate) || dateOfBirth.isAfter(currentDate)) {
            throw DateOfBirthValidationException("Некорректная дата рождения")
        }
    }

    fun validateGender(gender: Gender) {
        if (gender !in listOf(Gender.Male, Gender.Female)) {
            throw GenderValidationException("Некорректное значение пола")
        }
    }

    fun validateWeight(weight: String) {
        try {
            val weightValue = weight.toDouble()
            if (weightValue <= 0) {
                throw WeightValidationException("Некорректный вес")
            }
        } catch (e: NumberFormatException) {
            throw WeightValidationException("Некорректный вес")
        }
    }
}

fun main() {
    val formValidator = FormValidator()
    val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    while (true) {

        print("Введите имя (или 'end' для завершения): ")
        val name = readln()
        if (name == "end") {
            break
        }
        val result = runCatching {
            formValidator.validateName(name)

            print("Введите дату рождения (дд.мм.гггг): ")
            val dateOfBirth = LocalDate.parse(readln(), dateFormatter)

            print("Введите пол (М/Ж): ")
            val gender = when (readln().trim()) {
                "М" -> Gender.Male
                "Ж" -> Gender.Female
                else -> null
            }
            print("Введите вес: ")
            val weightStr = readln()
            formValidator.validateDateOfBirth(dateOfBirth)
            gender?.let { formValidator.validateGender(it) }
            formValidator.validateWeight(weightStr)
        }

        result.onFailure {
            println("Ошибка валидации: ${it.message}")
        }.onSuccess {
            println("Анкета корректна")
        }
    }
}

