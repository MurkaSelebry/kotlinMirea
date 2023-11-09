package prac9

abstract class Animal(val name: String, val speed: Double) {
    abstract fun wayOfBirth()
    fun eat(){
        println("$name ест")
    }
    fun sleep(){
        println("$name спит")
    }
    fun move() {
        println("$name двигается со скоростью $speed км/ч")
    }
}

abstract class Mammal(name: String, speed: Double) : Animal(name, speed) {
    override fun wayOfBirth() {
        println("Рожает")
    }
}

abstract class Fish(name: String, speed: Double) : Animal(name, speed) {
    override fun wayOfBirth() {
        println("Мечет икру")
    }
}

abstract class Bird(name: String, speed: Double) : Animal(name, speed) {
    override fun wayOfBirth() {
        println("Откладывает яйца")
    }
}

interface Flying {
    fun fly(){
        println("Летает")
    }
}

interface Swimming {
    fun swim(){
        println("Плавает")
    }
}

class Bat(name: String, speed: Double) : Mammal(name, speed), Flying {
    override fun fly() {
        println("$name летит в пещере")
        move()
    }
}

class Dolphin(name: String, speed: Double) : Mammal(name, speed), Swimming {
      override fun swim() {
        println("$name в океане")
          move()
    }
}

class GoldFish(name: String, speed: Double) : Fish(name, speed), Swimming{
    override fun swim() {
        println("$name в море")
        move()

    }
}

class Eagle(name: String, speed: Double) : Bird(name, speed), Flying {
    override fun fly() {
        println("$name летит в небе")
        move()
    }
}

fun main() {
    val bat = Bat("Летучая мышь", 40.0)
    val dolphin = Dolphin("Дельфин", 30.0)
    val goldFish = GoldFish("Золотая рыбка", 10.0)
    val eagle = Eagle("Орел", 100.0)

    println("Тестирование Bat:")
    bat.eat()
    bat.sleep()
    bat.wayOfBirth()
    bat.fly()

    println("\nТестирование Dolphin:")
    dolphin.eat()
    dolphin.sleep()
    dolphin.wayOfBirth()
    dolphin.swim()

    println("\nТестирование GoldFish:")
    goldFish.eat()
    goldFish.sleep()
    goldFish.wayOfBirth()
    goldFish.swim()

    println("\nТестирование Eagle:")
    eagle.eat()
    eagle.sleep()
    eagle.wayOfBirth()
    eagle.fly()
}
