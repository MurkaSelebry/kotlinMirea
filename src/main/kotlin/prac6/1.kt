package prac6

class TimeUnit(hours: Int) {
    private var hours: Int = 0
    private var minutes: Int = 0
    private var seconds: Int = 0

    init {
        if (hours in 0 until 24) {
            this.hours = hours
        } else {
            println("Invalid hours value: $hours")
        }
    }

    constructor(hours: Int, minutes: Int) : this(hours) {
        if (seconds in 0 until 60) {
            this.minutes = minutes
        } else {
            println("Invalid seconds value: $seconds")
        }
    }

    constructor(hours: Int, minutes: Int, seconds: Int) : this(hours, minutes) {
        if (seconds in 0 until 60) {
            this.seconds = seconds
        } else {
            println("Invalid seconds value: $seconds")
        }    }

    fun showTime24() {
        println("$hours:$minutes:$seconds")
    }

    fun showTime12(){
        println("${if(hours<=12) hours else hours-12}:${minutes}:${seconds} ${if(hours<=12) "am" else "pm"}")
    }


    // Метод для прибавления времени к текущему времени
    fun addTime(hoursToAdd: Int, minutesToAdd: Int, secondsToAdd: Int) {
        hours += hoursToAdd
        minutes += minutesToAdd
        seconds += secondsToAdd

        if (seconds >= 60) {
            minutes += seconds / 60
            seconds %= 60
        }

        if (minutes >= 60) {
            hours += minutes / 60
            minutes %= 60
        }

        if (hours >= 24) {
            hours %= 24
        }
    }

}

fun main() {
    val time1 = TimeUnit(15, 30, 45)
    val time2 = TimeUnit(1)
    time1.showTime24()
    time1.showTime12()
    time2.showTime24()
    time2.showTime12()
    time1.addTime(2, 15, 30)
    time2.addTime(1, 15, 30)
    time1.showTime24()
    time1.showTime12()
    time2.showTime24()
    time2.showTime12()

}
