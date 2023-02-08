import java.util.*

/**
 * Класс с командами
 */
class Manager {

    fun start(scannerStart: Scanner){
        println("RobCo Pip-Boy 2000 приветствует вас! Авторизуйтесь.")
        val name = scannerStart.nextLine()
        println("Привет, $name!")
    }

    fun end(){
        println("Удачи!")
    }

    fun help(){
        println("Доступные комманды:")
        println("1. Запуск программы - start;")
        println("2. Запарковать автомобиль - park;")
        println("3. Возвратить автомобиль - return;")
        println("4. Поиск машины по номеру - park_info_by_car;")
        println("5. Справка по месту парковки - park_info_by_place;")
        println("6. Завершение программы - end.")
    }

    fun returnCar(scannerStart: Scanner, parkingMap:MutableMap<Int, Car?> ){
        println("Введите номер автомобиля")
        val number = scannerStart.nextLine()
        println("Введите ФИО владельца")
        val name = scannerStart.nextLine()
        val place = getPlaceByNumber(number, parkingMap)

        if (place !=null){
            val owner = getOwnerByNumber(place, parkingMap)
            if (owner == name){
                parkingMap[place]?.isParking = false // изменилось состояние машины, не запарковано
                parkingMap[place] = null // освободили место
                println("Автомобиль выдан владельцу")
            } else {
                println ("Ошибка")
            }
        }
    }

    fun parking(scannerStart: Scanner, parkingMap:MutableMap<Int, Car?>){
        println("Введите номер автомобиля")
        val number = scannerStart.nextLine()
        println("Введите ФИО владельца")
        val name = scannerStart.nextLine()
        val car = Car(
            "неизвестно",
            "неизвесно",
            number,
            name,
            )
       val place = parkingMap.filter { it.value==null }.keys.elementAtOrNull(0)
       if (place!=null) {
           car.isParking = true
           parkingMap[place] = car
           println( "Запарковано")
       }
    }


    fun parkInfoByCar (scannerStart: Scanner, map: MutableMap <Int, Car?>): Int? {
        println("Введите номер автомобиля")
        val number = scannerStart.nextLine()
        val place= getPlaceByNumber(number, map)
        if ( place != null){
            println("Машина с номером $number расположена на парковочном месте - $place")
        }
        else { println("Машина с номером $number  на парковочном месте нет")
        }
        return place
    }

    fun parkInfoByPlace (scannerStart: Scanner, map: MutableMap <Int, Car?>) {
        println("Введите номер парковочного места")
        val input = scannerStart.nextLine().toInt()
        val value = map[input]
        println("На парковочном месте $input - $value")

    }
    private fun getPlaceByNumber(number: String, map: MutableMap <Int, Car?>): Int?{
        return map.entries.find { it.value?.number == number }?.key
    }

    private fun getOwnerByNumber(place: Int, map: MutableMap <Int, Car?>): String? {
        return map[place]?.owner
    }
}