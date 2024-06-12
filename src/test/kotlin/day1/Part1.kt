package day1

import org.junit.jupiter.api.Test

class Part1 {

    fun solution(s: String): Int {
        val lines = s.split("\n")
        return lines.fold(0) { acc, line ->
            val firstDigit = line.first { it.isDigit() }.digitToInt()
            val lastDigit = line.last { it.isDigit() }.digitToInt()
            val combine = firstDigit * 10 + lastDigit
            (acc + combine)
        }

    }

    @Test
    fun part1() {
        val s = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()

        println(solution(s))
    }
}