import kotlin.math.min

val minutesWordForms = arrayOf("минуту", "минуты", "минут")
val hoursWordForm = arrayOf("час", "часа", "часов")


fun main() {
    while (true) {
        try {
            println("Введите количество секунд, exit для выхода")
            val line = readLine()
            val seconds = line!!.toInt()
            if (seconds < 0) {
                throw NegativeNumberException()
            }
            if (line == "exit") {
                break
            }
            println(getTimeAgoType(seconds))
        } catch (e: NegativeNumberException) {
            println("Значение должно быть больше нуля")
        } catch (e: Exception) {
            println("Введено некоректное значение")
        }
    }
}

fun getPluralForm(count: Int, words: Array<String>): String {
    val cases = intArrayOf(2, 0, 1, 1, 1, 2)
    return words[if (count % 100 in 5..19) 2 else cases[min(count % 10, 5)]]
}

fun getTimeAgoType(seconds: Int): String {
    return when {
        (seconds <= TimeAgo.JUST_NOW.ends) -> "только что"
        (seconds <= TimeAgo.MINUTES_AGO.ends) -> getMinutesTime(seconds)
        (seconds <= TimeAgo.HOURS_AGO.ends) -> getHoursTime(seconds)
        (seconds <= TimeAgo.TODAY.ends) -> "сегодня"
        (seconds <= TimeAgo.YESTERDAY.ends) -> "вчера"
        else -> "давно"
    }
}

fun getMinutesTime(seconds: Int): String {
    val minutes = seconds / 60
    return "$minutes ${getPluralForm(minutes, minutesWordForms)} назад"
}

fun getHoursTime(seconds: Int): String {
    val hours = seconds / (60 * 60)
    return "$hours ${getPluralForm(hours, hoursWordForm)} назад"
}
