package prac8

enum class DrinkType(private val volume: Double) {
    COLA(0.33),
    WATER(0.5),
    TEA(0.2),
    ALCOHOL(0.1),
    MILK(0.25);

    fun getDisplayName(): String {
        return when (this) {
            COLA -> "CocaCola"
            WATER -> "Вода"
            TEA -> "Чай"
            ALCOHOL -> "Алкоголь"
            MILK -> "Молоко"
        }
    }


    companion object {
        fun getDrinkVolume(type: DrinkType): Double {
            return type.volume
        }
    }


}

fun main() {
    println("Меню напитков:")
    println("--------------")

    val drinks = listOf(
        DrinkType.COLA,
        DrinkType.WATER,
        DrinkType.TEA,
        DrinkType.ALCOHOL,
        DrinkType.MILK
    )

    for (drink in drinks) {
        val name = drink.getDisplayName()
        val volume = DrinkType.getDrinkVolume(drink)

        println("Напиток: $name")
        println("Объем: $volume литра")
        println("--------------")
    }
}