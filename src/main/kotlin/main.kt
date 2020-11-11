import pt.isel.canvas.*

data class Smile(val x: Int, val y: Int, val radius: Int)

val canvas: Canvas = Canvas(800, 400, CYAN)

fun main() {
       actions(canvas)
}
