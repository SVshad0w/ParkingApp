/**
 * Класс Автомобиль
 * @property mark марка
 * @property color цвет
 * @property number номер автомобиля
 * @property owner владелец
  */
data class Car(
    val mark: String,
    val color: String,
    val number: String,
    val owner: String,
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (mark != other.mark) return false
        if (color != other.color) return false
        if (number != other.number) return false
        if (owner != other.owner) return false

        return true
    }

    override fun hashCode(): Int {
        var result = mark.hashCode()
        result = 31 * result + color.hashCode()
        result = 31 * result + number.hashCode()
        result = 31 * result + owner.hashCode()
        return result
    }

    override fun toString(): String {
        return "Авто('$mark', '$color', '$number', владелец:'$owner')"
    }
}