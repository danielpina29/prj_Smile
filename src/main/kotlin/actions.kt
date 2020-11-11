import pt.isel.canvas.*

/**
 *
 */

private const val UP_KEY_CODE = 38
private const val DOWN_KEY_CODE = 40
private const val LEFT_KEY_CODE = 37
private const val RIGHT_KEY_CODE = 39
private const val  DELTA_CURSOR = 4
private const val DELTA_RADIUS = 1

/**
 *The function actions has the job of drawing new smiles based on user actions both on keyboard and mouse.
 */

fun actions (canvas: Canvas) {
    onStart {
        var smile = Smile(x = canvas.width / 2, y = canvas.height / 2, radius = 50)
        drawSmile(smile)
        canvas.onKeyPressed {
            when (it.char) {
                '+' -> smile= Smile(smile.x, smile.y, smile.radius + DELTA_RADIUS)
                '-' -> smile= Smile(smile.x, smile.y, smile.radius - DELTA_RADIUS)
            }
            when (it.code) {
                DOWN_KEY_CODE -> smile = Smile(smile.x,smile.y + DELTA_CURSOR, smile.radius)
                RIGHT_KEY_CODE -> smile= Smile(smile.x + DELTA_CURSOR, smile.y, smile.radius)
                LEFT_KEY_CODE -> smile= Smile(smile.x - DELTA_CURSOR, smile.y, smile.radius)
                UP_KEY_CODE -> smile= Smile(smile.x, smile.y - DELTA_CURSOR, smile.radius)
            }
            drawSmile(smile)
            canvas.erase()
        }
        canvas.onMouseDown {
            smile = Smile(it.x, it.y, smile.radius)
            drawSmile(smile)
            canvas.erase()
        }
    }
    onFinish {
        println("Bye Bye!!!")
    }
}