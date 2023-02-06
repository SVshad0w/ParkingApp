import java.util.*

fun main(args: Array<String>) {
    hello ()
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