package prac3

import java.util.Scanner
import kotlin.random.Random

val scan = Scanner(System.`in`)

fun main(args: Array<String>) {
    game()
    morzeGame()
    passwordGen()
}

fun game(){
    val hiddenM = Random.nextInt(0,1000)
    println(hiddenM)
    println("Введите число:")
    var x = scan.nextInt()
    while(x!=hiddenM){
        if(x<0){
            println("Вы завершили игру досрочно!")
            return
        }
        if(x>hiddenM){
            println("Больше загадонного!")
        }
        else{
            println("Меньше загадонного")
        }
        println("Введите число:")
        x = scan.nextInt()
    }
    println("Вы победили!")
}
fun morzeGame(){
    val morze = arrayOf(".-  ","-...",".-- ","--. ",
        "-.. ",".   ","...-","--..",
        "..  ",".---","-.- ",".-..",
        "--  ","-.  ","--- ",".--.",
        ".-. ","... ","-   ","..- ",
        "..-.","....","-.-.","---.",
        "----","--.-","-..-","-.--",
        "-..-","..-.","..--",".-.-")
    println("Введите строку:")
    val stringS = readln()
    for(let in stringS){
        print(morze[let.code-'А'.code]+' ')
    }
}
fun passwordGen(){
    println("Введите размер пароля:")
    var n = scan.nextInt()
    while(n<8){
        println("Пароль с N кол-вом символов небозапасен")
        n = scan.nextInt()
    }
    val N = n
    val pswd = Array(N) {""}
    val countL = N/4;
    val countl = N/4;
    val countS = N/4;
    val countN = N/4 + N%4;

    var lastI = 0
    for(i in lastI until countL+lastI){
        pswd[i] = Random.nextInt('A'.code, 'Z'.code).toChar().toString()
    }
    lastI+=countL;
    for(i in lastI until countl+lastI){
        pswd[i] = Random.nextInt('a'.code, 'z'.code).toChar().toString()
    }
    lastI+=countl;
    val spec = arrayOf('_','*','-')
    for(i in lastI until countS+lastI){
        pswd[i] = spec[Random.nextInt(0,2)].toString()
    }
    lastI+=countS;
    for(i in lastI until countN+lastI){
        pswd[i] = Random.nextInt(0,9).toString()
    }
   pswd.shuffle()
    print(pswd.joinToString(""))
}