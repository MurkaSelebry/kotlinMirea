package prac12

abstract class Vehicle(val speed: Double) {
    abstract fun move()
}

class WaterVehicle(speed: Double, val numberOfKilowatts: Int = 10) : Vehicle(speed) {
    override fun move() {
        println("Судно имеет мощность равную $numberOfKilowatts кВт")
    }
}

class AirVehicle(speed: Double, val thousandsHorsepower: Double=100.0) : Vehicle(speed) {
    override fun move() {
        println("Мощность воздушного транспорт составляет $thousandsHorsepower л/c")
    }
}

class RoadVehicle(speed: Double, val engineCapacity: Double, val numberOfHorsepower: Int) : Vehicle(speed) {
    override fun move() {
        println("Автомобильный транспорт:\nОбъем двигателя: $engineCapacity л/c: $numberOfHorsepower")
    }
}

class RailVehicle(speed: Double, val tangentialPower: Int = 400) : Vehicle(speed) {
    override fun move() {
        println("Касательная мощность жд транспорта: $tangentialPower кВт")
    }
}

fun List<Vehicle>.filterBySpeed(maxSpeed: Double, isLess: Boolean): List<Vehicle> {
    return this.filter { if(isLess) it.speed <= maxSpeed else it.speed >= maxSpeed }
}

fun List<Vehicle>.printInfo() {
    this.forEach { vehicle -> vehicle.printDetails() }
}


fun Vehicle.printDetails() {
    println("Вид: ${this::class.simpleName}, Скорость: ${this.speed}")
}

fun main() {
    val vehicles = listOf(
        WaterVehicle(60.0, 2),
        AirVehicle(200.0, 1000.0),
        RoadVehicle(120.0, 4.0, 300),
        RailVehicle(100.0, 10),
        WaterVehicle(70.0, 1),
        AirVehicle(150.0, 500.0),
        RoadVehicle(100.0, 2.0, 150),
        RailVehicle(80.0, 5)
    )

    val maxSpeed = 100.0
    val filteredVehicles = vehicles.filterBySpeed(maxSpeed, true)

    println("Т/С со скорость меньше или равной $maxSpeed")
    filteredVehicles.printInfo()
    println("Т/С со скорость больше или равной $maxSpeed")
    vehicles.filterBySpeed(maxSpeed, false).printInfo()
}

