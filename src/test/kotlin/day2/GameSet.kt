package day2


class GameSet(
    val redCubesAppearances: List<Int>,
    val blueCubesAppearances: List<Int>,
    val greenCubesAppearances: List<Int>,
) {

    fun maxRed() = redCubesAppearances.maxOrNull()
    fun maxBlue() = redCubesAppearances.maxOrNull()
    fun maxGreen() = redCubesAppearances.maxOrNull()

    companion object {

        fun fromString(s: String): GameSet {
            val cubes = s.split(",")

            val numberOfBlueCubes = mutableListOf<Int>()
            val numberOfRedCubes = mutableListOf<Int>()
            val numberOfGreenCubes = mutableListOf<Int>()

            cubes.forEach {
                val cube = it.trim().split(" ")
                when(cube.last()) {
                    "red" -> numberOfRedCubes.add(cube.first().toInt())
                    "blue" -> numberOfBlueCubes.add(cube.first().toInt())
                    "green" -> numberOfGreenCubes.add(cube.first().toInt())
                }
            }

            return GameSet(numberOfRedCubes.toList(),numberOfBlueCubes.toList(),numberOfGreenCubes.toList())
        }
    }

}