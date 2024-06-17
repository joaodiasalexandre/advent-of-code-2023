package day2


fun toGames(input: String): List<Game> =
    input.split("\n")
        .map { it.split(":") }
        .associate { it.first().split(" ").last() to it.last() }
        .mapValues { sets ->
            sets.value.split(";")
                .map { set -> GameSet.fromString(set) }
        }.map {
            Game(it.key.toInt(), it.value)
        }

class Game(
    val id: Int,
    private val sets: List<GameSet>
) {
    fun isValid(): Boolean =
        sets.all { set ->
            set.redCubesAppearances.all { it <= 12 } &&
                    set.blueCubesAppearances.all { it <= 14 } &&
                    set.greenCubesAppearances.all { it <= 13 }
        }
}

class GameSet(
    val redCubesAppearances: List<Int>,
    val blueCubesAppearances: List<Int>,
    val greenCubesAppearances: List<Int>,
) {

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