package prac2

import java.util.Scanner
val scan = Scanner(System.`in`)

fun main(args: Array<String>) {
    println("Тестирование 1 задачи:")
    task1()
    println("Тестирование 2 задачи:")
    task2()
    println("Тестирование 3 задачи:")
    task3()
}
fun task1(){
    val N = scan.nextInt()
    val numbers = Array(N, {i -> scan.nextDouble()})
    print("Среднее арифмитическое: ${numbers.average()}")
}
fun task2(){
    val N = scan.nextInt()
    val numbers = Array(N, {i -> scan.nextInt( )})
    val map = mutableMapOf<Int,Int>()
    for(el in numbers){
        if(map.containsKey(el)){
            map += el to map.getValue(el)+1
        }
        else{
            map[el] = 1
        }
    }
    map.forEach{entry ->
        println("Кол-во элементов ${entry.value} Элемент ${entry.key}")
    }
}
fun task3(){
    val N = scan.nextInt()
    val strings = Array(N, {i -> scan.next( ).orEmpty()})
    for (i in 0..N-2){
        for(j in i+1..N-1){
            if(strings[i]==strings[j]){
                println("Дубликат: ${strings[i]}")
                return
            }
        }
    }
    println("Дубликата нет")

}

