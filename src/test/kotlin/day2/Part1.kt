package day2

import org.junit.jupiter.api.Test
import readText

class Part1 {

    private fun solution(input: String) =
        toGames(input)
            .filter { it.isValid() }
            .sumOf { it.id }


    @Test
    fun test() {
        val input1 = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
        """.trimIndent()

        println("Input1 result: ${solution(input1)}. Should be 8")

        val input2 = readText("day2/input_part1.txt")
        println("Input1 result: ${solution(input2)}. Should be 3059")
    }
}