    fun main(args: Array<String>) {
    println("Тестирование 1 задачи:")
        task1()
    println("Тестирование 2 задачи:")
        task2()
    }
    fun task1() {
        print("Введите ДНК:")
        val str = readln()
        var timin = 0
        var guanin = 0
        var citozin = 0
        var adenin = 0
        for (let in str.orEmpty()){
            when(let){
                'A' -> adenin++
                'T' -> timin++
                'G' -> guanin++
                'C' -> citozin++
            }
        }
        println("$adenin $timin $guanin $citozin")
    }
    fun task2(){
        print("Введите количество денег для размена:")
        val n = readln().toInt()
        var exchange: Int = n
        var startExchange = 8
        val numbers = Array(8,{0})
        while(exchange>0){
            numbers[startExchange-1]=exchange/startExchange
            exchange-=numbers[startExchange-1]*startExchange
            startExchange/=2
        }
        println("Ваши $n в: 8-${numbers.get(7)} 4-${numbers.get(3)} 2-${numbers.get(1)} 1-${numbers.get(0)}")
    }
