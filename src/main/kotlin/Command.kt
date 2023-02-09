enum class Command(val input: String) {
    START("start"),
    HELP("help"),
    END("end"),
    RETURN("return"),
    PARKING("parking"),
    PARK_BY_CAR("park_info_by_car"),
    PARK_BY_PLACE("park_info_by_place"),
    PARK_STATS("park_stats"),
    PARK_LOAD("park_all_stats");

    companion object {
        infix fun from(value: String): Command? = Command.values().firstOrNull { it.input == value }
    }
}