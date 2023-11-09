package prac4
import java.util.Scanner
val scan = Scanner(System.`in`)
fun main() {
   // task1()
    //task2()
    task3()
}
fun task1(){
    val N = scan.nextInt()
    val matrix = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        for (j in 0 until N) {
            matrix[i][j] = scan.nextInt();
        }
    }

    val result = isSymmetric(matrix, N)
    println(result)
}

fun isSymmetric(matrix: Array<IntArray>, N: Int): Boolean {

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (matrix[i][j] != matrix[N - 1 - j][N - 1 - i]) {
                return false
            }
        }
    }
    return true
}
fun task2() {
    val weeklyNorms = readWeeklyNorms()
    val weeklyConsumption = readWeeklyConsumption()

    val result = checkNutrient(weeklyNorms, weeklyConsumption)

    println(result)
}

fun readWeeklyNorms(): IntArray {
    val norms = IntArray(3)

    //print("Введите недельную норму белков: ")
    norms[0] = scan.nextInt()

    //print("Введите недельную норму жиров: ")
    norms[1] = scan.nextInt()

    //print("Введите недельную норму углеводов: ")
    norms[2] = scan.nextInt()

    return norms
}

fun readWeeklyConsumption(): Array<IntArray> {
    val weeklyConsumption = Array(7) { IntArray(4) }

    for (day in 1..7) {
        weeklyConsumption[day - 1][0] = scan.nextInt()

        weeklyConsumption[day - 1][1] = scan.nextInt()

        weeklyConsumption[day - 1][2] = scan.nextInt()
        weeklyConsumption[day - 1][3] = scan.nextInt()
    }

    return weeklyConsumption
}

fun checkNutrient(weeklyNorms: IntArray, weeklyConsumption: Array<IntArray>): String {
    val totalConsumption = IntArray(4)

    for (day in 0 until 7) {
        for (nutrient in 0 until 4) {
            totalConsumption[nutrient] += weeklyConsumption[day][nutrient]
        }
    }

    return if (totalConsumption[0] <= weeklyNorms[0] &&
        totalConsumption[1] <= weeklyNorms[1] &&
        totalConsumption[2] <= weeklyNorms[2] &&
        totalConsumption[3] <= weeklyNorms[3]
    ) {
        "Отлично"
    } else {
        "Нужно есть поменьше"
    }
}
fun task3() {
    val words = readln().split(" ")
    val k = scan.nextInt()
    val result = kMostFrequentWords(words, k)
    println(result)
}
fun kMostFrequentWords(words: List<String>, k: Int): List<String> {
    val wordCount = mutableMapOf<String, Int>()

    for (word in words) {
        wordCount[word] = wordCount.getOrDefault(word, 0) + 1
    }
   // println(wordCount)
    val sortedWords = wordCount.entries.sortedWith(compareBy({ -it.value }, { it.key }))

    val result = sortedWords.take(k).map { it.key }

    return result
}
