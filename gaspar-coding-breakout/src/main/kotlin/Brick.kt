import java.awt.Point

class Brick(override var x: Int, override var y: Int) : Sprite() {

    var destroyed: Boolean = false

    init {
        loadImage("brick.png")
        setImageDimensions()
    }

    fun isAlive() = !destroyed

    fun crash() {

        destroyed = true
    }

    fun hitTo(point: Point) = awtRectangle().contains(point)

    override fun toString(): String {
        return "Brick(x=$x, y=$y, destroyed=$destroyed)"
    }


}