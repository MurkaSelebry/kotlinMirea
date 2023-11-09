package prac6
import java.util.Scanner

class Atm(private val usdToRubRate: Double, private val rubToUsdRate: Double) {

    fun rublesToDollars(amountInRubles: Double): Double {
        if (amountInRubles < 0) {
            println("Минимальная сумма 1 рубль")
        }
        return amountInRubles / rubToUsdRate
    }

    fun dollarsToRubles(amountInDollars: Double): Double {
        if (amountInDollars < 0) {
            println("Минимальная сумма 1 доллар")
        }
        return amountInDollars * usdToRubRate
    }
    fun startConsoleMenu() {
        println("Добро пожаловать в банкомат!")
        var exit = false

        while (!exit) {
            println("\nВыберите операцию:")
            println("1. Конвертировать рубли в доллары")
            println("2. Конвертировать доллары в рубли")
            println("Для выхода введите 'end'")
            val scan = Scanner(System.`in`)
            val choice = readln()

            when (choice) {
                "1" -> {
                    println("Введите сумму в рублях для конвертации в доллары:")
                    val amountInRubles = scan.nextDouble()
                    val amountInDollars = rublesToDollars(amountInRubles)
                    println("Результат: $amountInDollars долларов")
                }
                "2" -> {
                    println("Введите сумму в долларах для конвертации в рубли:")
                    val amountInDollars = scan.nextDouble()
                    val amountInRubles = dollarsToRubles(amountInDollars)
                    println("Результат: $amountInRubles рублей")
                }
                "end" -> {
                    exit = true
                }
                else -> {
                    println("Некорректный выбор операции. Попробуйте еще раз.")
                }
            }
        }

        println("Спасибо за использование банкомата!")
    }
}
fun main(){
    val atm = Atm(97.0,95.0)
    atm.startConsoleMenu()

}