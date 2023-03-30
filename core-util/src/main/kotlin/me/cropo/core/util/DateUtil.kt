package me.cropo.core.util

import me.cropo.core.util.type.DatePattern
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtil {
    companion object {
        fun parse(date: String, pattern: DatePattern): LocalDateTime? {
            return try {
                LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern.type))
            } catch (_: Exception) {
                null
            }
        }

        fun toString(date: LocalDateTime, pattern: DatePattern): String {
            return try {
                date.format(DateTimeFormatter.ofPattern(pattern.type))
            } catch (_: Exception) {
                ""
            }
        }
    }
}