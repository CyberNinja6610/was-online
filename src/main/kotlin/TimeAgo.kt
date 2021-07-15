enum class TimeAgo(val ends: Int) {
    JUST_NOW(60),
    MINUTES_AGO(60 * 60),
    HOURS_AGO(24 * 60 * 60),
    TODAY(2 * 24 * 60 * 60),
    YESTERDAY(3 * 24 * 60 * 60),
}
