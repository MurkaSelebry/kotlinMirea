package prac9


class BestRepairEver {
    fun IsRepairDevice(device: Device): Boolean {
        if((device  is Phone) || (device is Computer)) {
            return device.state > 50
        }
        return false
    }
}

abstract class Device(val state: Int)

open class Phone(state: Int) : Device(state)

class Smartphone(state: Int) : Phone(state)
class BasicPhone(state: Int) : Phone(state)
class FeaturePhone(state: Int) : Phone(state)

open class Computer(state: Int) : Device(state)

class Laptop(state: Int) : Computer(state)
class DesktopComputer(state: Int) : Computer(state)
class Server(state: Int) : Computer(state)


class Cleaner(state: Int) : Device(state)


fun main() {
    val repairService = BestRepairEver()
    while(true) {
        println("Выберите устройство для ремонта или -1 для выхода:")
        println("1. Smartphone")
        println("2. BasicPhone")
        println("3. FeaturePhone")
        println("4. Laptop")
        println("5. DesktopComputer")
        println("6. Server")
        println("7. Cleaner")

        print("Введите номер устройства: ")
        val choice = readln().toInt()
        if (choice == -1) break

        if (choice in 1..7) {
            print("Введите состояние устройства (от 0 до 100): ")
            val state = readln().toInt()

            if (state in 0..100) {
                val selectedDevice: Device? = when (choice) {
                    1 -> Smartphone(state)
                    2 -> BasicPhone(state)
                    3 -> FeaturePhone(state)
                    4 -> Laptop(state)
                    5 -> DesktopComputer(state)
                    6 -> Server(state)
                    7 -> Cleaner(state)
                    else -> null
                }

                if (selectedDevice != null) {
                    val isRepairable = repairService.IsRepairDevice(selectedDevice)
                    if (isRepairable) {
                        println("Устройство можно отремонтировать.")
                    } else {
                        println("Устройство не подлежит ремонту.")
                    }
                } else {
                    println("Неверный выбор устройства.")
                }
            } else {
                println("Неверное состояние устройства. Введите значение от 0 до 100.")
            }
        } else {
            println("Неверный выбор устройства.")
        }
    }
}
