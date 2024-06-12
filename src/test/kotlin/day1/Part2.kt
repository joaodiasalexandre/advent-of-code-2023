package day1

import org.junit.jupiter.api.Test
import readText

class Part2 {

    fun solution2(s: String): Int {
        val lines = s.split("\n")
        val writtenNumberRegex = "(?=(one|1|two|2|three|3|four|4|five|5|six|6|seven|7|eight|8|nine|9))".toRegex()

        return lines.fold(0) { acc, line ->
            val matches = writtenNumberRegex.findAll(line).map { it.groups[1] }
            val firstDigit = matches.first()?.value?.let { toDigit(it) }
            val lastDigit = matches.last()?.value?.let { toDigit(it) }
            val combination = "$firstDigit$lastDigit".toInt()

            acc + combination
        }
    }

    private fun toDigit(s: String): Int =
        when (s) {
            "one", "1" -> 1
            "two", "2" -> 2
            "three", "3" -> 3
            "four", "4" -> 4
            "five", "5" -> 5
            "six", "6" -> 6
            "seven", "7" -> 7
            "eight", "8" -> 8
            "nine", "9" -> 9
            else -> throw Exception()
        }

    @Test
    fun part2() {
        val input1 = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent()
        println("Input1 result: ${solution2(input1)}")

        val input2 = readText("day1/input2.txt")
        println("Input2 result: ${solution2(input2)}")
    }
}