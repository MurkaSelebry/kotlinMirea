package prac10

fun main() {
    val anUser = object : ListObj() {
        override val listObj: List<User> = listOf(
            User("Михаил", 25),
            User("Архангел", 35),
            User("Максим", 30)
        )
    }

    val oldestUser = anUser.listObj.maxByOrNull { it.age }
    oldestUser?.let {
        println("Самый старший пользователь: ${it.name}, возраст ${it.age} лет")
    }
}

open class ListObj {
    open val listObj: List<User> = emptyList()
}

data class User(val name: String, val age: Int)
