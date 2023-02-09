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