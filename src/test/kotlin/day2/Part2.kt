package day2

import org.junit.jupiter.api.Test
import readText

class Part2 {

    private fun solution(input: String) =
        toGames(input)
            .map {
                it.sets.fold(MaxCubes()) { acc: MaxCubes, set ->
                    acc.calculateMaxCubes(set)
                }
            }.sumOf {
                it.red * it.blue * it.green
            }

    class MaxCubes {
        var red: Int = 0
            private set
        var blue: Int = 0
            private set
        var green: Int = 0
            private set

        fun calculateMaxCubes(set: GameSet): MaxCubes {
            set.redCubesAppearances.maxOrNull()?.takeIf { it > this.red }?.let { this.red = it }
            set.blueCubesAppearances.maxOrNull()?.takeIf { it > this.blue }?.let { this.blue = it }
            set.greenCubesAppearances.maxOrNull()?.takeIf { it > this.green }?.let { this.green = it }
            return this
        }
    }

    @Test
    fun test() {
        val input1 = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
        """.trimIndent()

        println("Input1 result: ${solution(input1)}. Should be 2286")

        val input2 = readText("day2/input_part2.txt")
        println("Input2 result: ${solution(input2)}. Should be 65371")

    }
}