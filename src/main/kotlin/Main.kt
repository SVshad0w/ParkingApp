import java.util.*

var countPark = 0

fun main(args: Array<String>) {

    val cars = fillCarBase()
    val parking = createParking()
    hello(parking)


}

fun hello(parkingMap: MutableMap<Int, Car?>) {
    val scannerStart = Scanner(System.`in`)

    val manager = Manager()
    val input = scannerStart.nextLine()

    when (Command.from(input)) {
        Command.START -> {
            manager.start(scannerStart)
            hello(parkingMap)
        }
        Command.HELP -> {
            manager.help()
            hello(parkingMap)
        }
        Command.END -> manager.end()
        Command.RETURN -> {
            manager.returnCar(scannerStart, parkingMap)
            hello(parkingMap)
        }
        Command.PARKING -> {
            manager.parking(scannerStart, parkingMap)
            hello(parkingMap)
        }
        Command.PARK_BY_CAR -> {
            manager.parkInfoByCar(scannerStart, parkingMap)
            hello(parkingMap)
        }
        Command.PARK_BY_PLACE -> {
            manager.parkInfoByPlace(scannerStart, parkingMap)
            hello(parkingMap)
        }
        Command.PARK_STATS -> {
            manager.parkStat(countPark)
            hello(parkingMap)
        }
        Command.PARK_LOAD -> {
            manager.parkLoad(parkingMap)
            hello(parkingMap)
        }
        null -> {
            println("Команда не может быть обработанна. Для вызова справки воспользуйтесь командой - help")
            hello(parkingMap)
        }

    }
}

/**
 * Метод для заполнения "базы" автомобилей
 */
fun fillCarBase(): Set<Car> {
    return setOf<Car>(
        Car("ferrari", "Red", "B999BB", "Vladimir Pupkin"),
        Car("ford", "Blue", "B777BB", "Michail Gubkin"),
        Car("ferrari", "Red", "B555BB", "Vladimir Pupkin"),
        Car("ferrari", "Red", "B444BB", "Vladimir Pupkin"),
        Car("ferrari", "Red", "B333BB", "Vladimir Pupkin")
    )
}

/**
 * Создаём map с парковочными местами
 * в качестве занчения map может принимать, либо Car, либо null
 * При создании все value = null
 */
fun createParking(): MutableMap<Int, Car?> {
    val map = mutableMapOf<Int, Car?>()
    for (i in 1..20) {
        map[i] = null
    }
    return map
}
