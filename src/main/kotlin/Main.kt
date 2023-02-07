import java.util.*

fun main(args: Array<String>) {
    hello ()
     val cars = fillCarBase()
    val parking = createParking()

}

fun hello () {
    val scannerStart  = Scanner(System.`in`)
    when (scannerStart.nextLine()) {
        "start" -> {
            println("RobCo Pip-Boy 2000 приветствует вас! Авторизуйтесь.")
            val name = scannerStart.nextLine()
            println("Привет, $name!")
        }
        "help" -> {
            println("Доступные комманды:")
            println("1. Запуск программы - start;")
            println("2. Завершение программы - end.")
            hello ()
        }
        "end" -> {
            println("Удачи!")
            return
        }
        else -> {
            println("Команда не может быть обработанна. Для вызова справки воспользуйтесь командой - help")
            hello ()
        }
    }
}

/**
 * Метод для заполнения "базы" автомобилей
 */
fun fillCarBase (): Set<Car> {
    return setOf <Car>(
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
fun createParking (): MutableMap<Int, Car?> {
    val map = mutableMapOf<Int, Car?>()
    for (i in 1..20) {
        map[i] = null
    }
    return map
}


/**
 * Класс Автомобиль
 * @property mark марка
 * @property color цвет
 * @property number номер автомобиля
 * @property owner владелец
 * @param isParking запаркован или нет
 */
data class Car(
    val mark: String,
    val color: String,
    val number: String,
    val owner: String,
    var isParking: Boolean = false
)

/**
 * Класс с командами
 */
enum class Command(
    //TODO будет заполнен по ходу появления команд
)