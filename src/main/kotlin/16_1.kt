package murad

data class SportsActivity(val participantName: String, val sportType: String, val duration: Int)

val activities = sequenceOf(
    SportsActivity("Alice", "Running", 30),
    SportsActivity("Pavel", "Running", 40),
    SportsActivity("Bob", "Cycling", 45),
    SportsActivity("Charlie", "Swimming", 60),
    SportsActivity("Dave", "Gym", 75),
    SportsActivity("Eve", "Yoga", 45),
    SportsActivity("Frank", "Soccer", 90),
    SportsActivity("Grace", "Tennis", 60),
    SportsActivity("Hannah", "Basketball", 90),
    SportsActivity("Ivan", "Hiking", 120),
    SportsActivity("Jane", "Golf", 90)
)

fun main() {
    val activitiesString = activities.map { "Участник: ${it.participantName}, Вид спорта: ${it.sportType}, Длительность: ${it.duration} мин." }
    println("Исходные активности:")
    activitiesString.forEach { activity -> println(activity) }

    val activitiesBySportType = activities.groupBy { it.sportType }
    println("\nАктивности, сгруппированные по виду спорта:")
    activitiesBySportType.forEach { (sportType, activities) ->
        println("$sportType: ${activities.map { "Участник: ${it.participantName}, Вид спорта: ${it.sportType}, Длительность: ${it.duration} мин." }.joinToString(", ")}")
    }

    val averageDurationBySportType = activitiesBySportType.map { (sportType, activities) ->
        val averageDuration = activities.map { it.duration }.average().toInt()
        "Вид спорта: $sportType, Средняя длительность: $averageDuration мин."
    }.asSequence()
    println("\nСредняя длительность активности для каждого вида спорта:")
    averageDurationBySportType.forEach { println(it) }
}