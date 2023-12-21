package murad
data class Country(val name: String, val continent: String, val population: Long, val area: Double) {
    override fun toString(): String {
        return "Название: $name, Континент: $continent, Население: $population, Площадь: $area км^2"
    }
}

val countries = sequenceOf(
    Country("United States", "North America", 331002651, 9525067.0),
    Country("Canada", "North America", 37742154, 9984670.0),
    Country("China", "Asia", 1444216107, 9596961.0),
    Country("India", "Asia", 1380004385, 3287263.0),
    Country("Australia", "Australia/Oceania", 25696886, 7692024.0),
    Country("Brazil", "South America", 212559417, 8515767.0),
    Country("Russia", "Europe", 145934462, 17098242.0),
    Country("Germany", "Europe", 83783942, 357022.0),
    Country("Japan", "Asia", 126476461, 377973.0),
    Country("United Kingdom", "Europe", 67886011, 242495.0)
)

fun main() {
        val europeanCountries = countries.filter { it.continent == "Europe" }
        println("Европейский страны:")
        europeanCountries.forEach { country -> println(country.toString()) }

        println("\n\nЕсть ли в европе страны с население, более 50м человек: ${if (europeanCountries.any { it.population > 50000000 }) "Да" else "Нет"}")

        val largeCountries = countries.filter { it.area > 500000.0 }
        println("\n\nСтраны с площадью более 500 тыс км^2:")
        largeCountries.forEach { country -> println(country.toString()) }

        println("\n\nВсе ли Большие страны с населением меньше 100 млн: ${if (largeCountries.all { it.population < 100000000 }) "Да" else "Нет"}")
}