package me.cropo.core.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtil {
    companion object {
        fun parse(date: String, pattern: DatePattern): LocalDateTime {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern.type))
        }

        fun toString(date: LocalDateTime, pattern: DatePattern) {
        }
    }
}