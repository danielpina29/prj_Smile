import pt.isel.canvas.*

/**
 * Represents a smile, with the following characteristics:
 * @property x        The x coordinate of the center of the Smile.
 * @property y        The y coordinate of the center of the Smile.
 * @property radius          The radius of the Smile.
 */

data class Smile(val x: Int, val y: Int, val radius: Int)

/**
 *This private constants, set the parameters which the smile is modified.
 */

private const val UP_KEY_CODE = 38
private const val DOWN_KEY_CODE = 40
private const val LEFT_KEY_CODE = 37
private const val RIGHT_KEY_CODE = 39
private const val DELTA_CURSOR = 4
private const val DELTA_RADIUS = 1

/**
 *The function actions has the job of drawing new smiles based on user inputs, both on keyboard and mouse.
 */

fun run() {
    onStart {
        val canvas: Canvas = Canvas(800, 400, CYAN)
        var smile = Smile(x = canvas.width / 2, y = canvas.height / 2, radius = 50)
        drawSmile(smile, canvas)
        canvas.onKeyPressed {
            smile = when {
                it.char == '+' -> Smile(smile.x, smile.y, smile.radius + DELTA_RADIUS)
                it.char == '-' -> Smile(smile.x, smile.y, smile.radius - DELTA_RADIUS)
                it.code == DOWN_KEY_CODE -> Smile(smile.x, smile.y + DELTA_CURSOR, smile.radius)
                it.code == RIGHT_KEY_CODE -> Smile(smile.x + DELTA_CURSOR, smile.y, smile.radius)
                it.code == LEFT_KEY_CODE -> Smile(smile.x - DELTA_CURSOR, smile.y, smile.radius)
                it.code == UP_KEY_CODE -> Smile(smile.x, smile.y - DELTA_CURSOR, smile.radius)
                else -> smile
            }
            canvas.erase()
            drawSmile(smile, canvas)

        }
        canvas.onMouseDown {
            smile = Smile(it.x, it.y, smile.radius)
            canvas.erase()
            drawSmile(smile, canvas)

        }
    }
    onFinish {
        println("Bye Bye!!!")
    }
}