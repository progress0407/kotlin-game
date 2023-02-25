import support.FileIoWrapper.Companion.readImageIcon
import java.awt.Image
import java.awt.Rectangle

open abstract class Sprite {

    open var x: Int = 0
        protected set

    open var y: Int = 0
        protected set

    var imageWidth: Int = 0
    var imageHeight: Int = 0

    lateinit var image: Image
        protected set

    fun awtRectangle() = Rectangle(x, y, image.getWidth(null), image.getHeight(null))

    protected fun setImageDimensions() {

        imageWidth = image.getWidth(null)
        imageHeight = image.getHeight(null)
    }

    protected fun loadImage(filePath: String) {

        image = readImageIcon(filePath).image
    }
}