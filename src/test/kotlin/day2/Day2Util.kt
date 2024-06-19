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