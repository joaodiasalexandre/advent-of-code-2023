import java.io.File
import kotlin.io.path.Path

fun readText(file: String): String =
    File("${Path("").toAbsolutePath()}/src/test/kotlin/$file").readText()