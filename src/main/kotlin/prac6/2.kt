package prac6



class AmazingString {
    private var charArray: CharArray

    constructor(charArray: CharArray) {
        this.charArray = charArray
    }

    constructor(str: String) {
        charArray = str.toCharArray()
    }

    fun length(): Int {
        return charArray.size
    }

    fun at(index: Int): Char {
        return if (index >= 0 && index < charArray.size) {
            charArray[index]
        } else {
            throw IndexOutOfBoundsException("Index out of bounds")
        }
    }

    override fun toString(): String {
        return String(charArray)
    }

    fun print() {
        println(toString())
    }

    fun contains(substring: CharArray): Boolean {
        return String(charArray).contains(String(substring))
    }

    fun contains(substring: String): Boolean {
        return String(charArray).contains(substring)
    }

    fun trimLeadingWhitespace() {
        charArray = String(charArray).removePrefix(" ").toCharArray()
    }

    fun reverse() {
        charArray = charArray.reversedArray()
    }

}

fun main() {
    val charArray = charArrayOf(' ','H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd')
    val amazingString1 = AmazingString(charArray)

    val str = " Hello, Kotlin!"
    val amazingString2 = AmazingString(str)

    println("Length of amazingString1: ${amazingString1.length()}")
    println("Character at index 4 in amazingString1: ${amazingString1.at(4)}")
    println("Length of amazingString2: ${amazingString2.length()}")
    println("Character at index 4 in amazingString2: ${amazingString2.at(4)}")

    amazingString1.print()
    amazingString2.print()

    println("Does amazingString1 contain 'lo'? ${amazingString1.contains("lo")}")
    println("Does amazingString2 contain 'Kotlin'? ${amazingString2.contains("Kotlin")}")
    println("Does amazingString2 contain charArray? ${amazingString2.contains(charArray)}")

    amazingString1.trimLeadingWhitespace()
    println("amazingString1 after trimming leading whitespace: ${amazingString1.toString()}")

    amazingString2.trimLeadingWhitespace()
    println("amazingString2 after trimming leading whitespace: ${amazingString2.toString()}")

    amazingString1.reverse()
    println("amazingString1 after reversing: ${amazingString1.toString()}")

    amazingString2.reverse()
    println("amazingString2 after reversing: ${amazingString2.toString()}")
}
