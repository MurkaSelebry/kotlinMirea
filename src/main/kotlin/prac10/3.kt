package prac10

open class MyEvenNumber(val n: Int) {
    init {
        if (n % 2 != 0) {
            throw IllegalArgumentException("Число должно быть четным")
        }
    }
}

class MyPrimeNumber(n: Int) : MyEvenNumber(n)

fun main() {
    val evenResult = runCatching { MyEvenNumber(10) }
    evenResult.onSuccess {
        println("Четное число: ${it.n}")
    }.onFailure {
        if (it is IllegalArgumentException) {
            println("Ошибка: ${it.message}")
        }
    }

    val evenNewResult = runCatching { MyPrimeNumber(11) }
    evenNewResult.onSuccess {
        println("Четное число: ${it.n}")
    }.onFailure {
        if (it is IllegalArgumentException) {
            println("Ошибка: ${it.message}")
        }
    }
}




