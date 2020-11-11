import pt.isel.canvas.*

private fun drawLEye (smile: Smile, canvas: Canvas) {
    canvas.drawCircle(
        xCenter = ((smile.x) - (0.35 * smile.radius)).toInt(),
        yCenter = ((smile.y) - (0.35 * smile.radius)).toInt(),
        radius = (0.125 * smile.radius).toInt(),
        color = BLACK
    )
}

private fun drawREye (smile: Smile, canvas: Canvas) {
    canvas.drawCircle(
        xCenter = ((smile.x) + (0.35 * smile.radius)).toInt(),
        yCenter = ((smile.y) - (0.35 * smile.radius)).toInt(),
        radius = (0.125 * smile.radius).toInt(),
        color = BLACK
    )
}

private fun drawMouth(smile: Smile, canvas: Canvas) {
    canvas.drawArc(
        xCenter = smile.x,
        yCenter = smile.y,
        radius = (smile.radius * 0.6).toInt(),
        startAng = 200,
        endAng = 340,
        color = BLACK,
        thickness = (0.07 * smile.radius).toInt()
    )
}

private fun outline(smile: Smile, canvas: Canvas) {
    canvas.drawCircle(
        xCenter = smile.x,
        yCenter = smile.y,
        radius = smile.radius,
        color = BLACK,
        thickness = (0.07 * smile.radius).toInt()
    )
}

private fun paintSmile (smile: Smile, canvas: Canvas) {
    canvas.drawCircle(
        xCenter = smile.x,
        yCenter = smile.y,
        radius = smile.radius,
        color = YELLOW,
    )
}

fun drawSmile(smile: Smile, canvas: Canvas) {
    paintSmile(smile, canvas)
    drawLEye(smile, canvas)
    drawREye(smile, canvas)
    drawMouth(smile, canvas)
    outline(smile, canvas)
}
