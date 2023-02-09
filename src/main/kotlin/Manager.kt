import java.util.*

/**
 * Класс с командами
 */
class Manager {

    fun start(scannerStart: Scanner) {
        println("RobCo Pip-Boy 2000 приветствует вас! Авторизуйтесь.")
        val name = scannerStart.nextLine()
        println("Привет, $name!")
    }

    fun end() {
        println("Удачи!")
    }

    fun parkStat(value: Int) {
        println("Количество парковок $value за время работы")
    }

    fun parkLoad(parkingMap: MutableMap<Int, Car?>) {
        val load = StringBuilder()
        parkingMap.forEach {
            val place: String = if (it.value == null) {
                "пусто"
            } else {
                it.value.toString()
            }
            load.append("место № ${it.key} - $place \n")
        }

        load.toString()
        println("Загрузка парковки: \n$load ")
    }

    fun help() {
        println("Доступные комманды:")
        println("1. Запуск программы - start;")
        println("2. Запарковать автомобиль - parking;")
        println("3. Возвратить автомобиль - return;")
        println("4. Поиск машины по номеру - park_info_by_car;")
        println("5. Справка по месту парковки - park_info_by_place;")
        println("6. Статистика количеству парковок- park_stats;")
        println("7. Загрузка парковки  - park_all_stats;")
        println("8. Завершение программы - end.")
    }

    fun returnCar(scannerStart: Scanner, parkingMap: MutableMap<Int, Car?>) {
        println("Введите номер автомобиля")
        val number = scannerStart.nextLine()
        println("Введите ФИО владельца")
        val name = scannerStart.nextLine()
        val place = getPlaceByNumber(number, parkingMap)

        if (place != null) {
            val owner = getOwnerByNumber(place, parkingMap)
            if (owner == name) {

                parkingMap[place] = null // освободили место
                println("Автомобиль выдан владельцу")
            } else {
                println("Ошибка")
            }
        }
    }

    fun parking(scannerStart: Scanner, parkingMap: MutableMap<Int, Car?>) {
        println("Введите номер автомобиля")
        val number = scannerStart.nextLine()
        println("Введите марку автомобиля")
        val mark = scannerStart.nextLine()
        println("Введите цвет автомобиля")
        val color = scannerStart.nextLine()
        println("Введите ФИО владельца")
        val name = scannerStart.nextLine()
        val car = Car(
            mark,
            color,
            number,
            name,
        )
        val place = parkingMap.filter { it.value == null }.keys.elementAtOrNull(0)
        if (place != null) {
            parkingMap[place] = car
            println("Запарковано")
            countPark++
        }
    }


    fun parkInfoByCar(scannerStart: Scanner, map: MutableMap<Int, Car?>): Int? {
        println("Введите номер автомобиля")
        val number = scannerStart.nextLine()
        val place = getPlaceByNumber(number, map)
        if (place != null) {
            println("Машина с номером $number расположена на парковочном месте - $place")
        } else {
            println("Машина с номером $number  на парковочном месте нет")
        }
        return place
    }

    fun parkInfoByPlace(scannerStart: Scanner, map: MutableMap<Int, Car?>) {
        println("Введите номер парковочного места")
        val input = scannerStart.nextLine().toInt()
        val value = map[input]
        println("На парковочном месте $input - $value")

    }

    private fun getPlaceByNumber(number: String, map: MutableMap<Int, Car?>): Int? {
        return map.entries.find { it.value?.number == number }?.key
    }

    private fun getOwnerByNumber(place: Int, map: MutableMap<Int, Car?>): String? {
        return map[place]?.owner
    }
}