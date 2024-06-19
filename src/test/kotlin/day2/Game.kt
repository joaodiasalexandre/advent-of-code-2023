package day2

class Game(
    val id: Int,
    val sets: List<GameSet>
) {
    fun isValid(): Boolean =
        sets.all { set ->
            set.redCubesAppearances.all { it <= 12 } &&
                    set.blueCubesAppearances.all { it <= 14 } &&
                    set.greenCubesAppearances.all { it <= 13 }
        }
}