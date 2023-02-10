package util

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.io.File
import javax.imageio.ImageIO

class ScreenshotUtil {
    fun takeScreenshot(fileName: String, formatName: String = "png") {
        val toolkit = Toolkit.getDefaultToolkit()
        val screenSize = toolkit.screenSize
        val screenRect = Rectangle(screenSize)
        val robot = Robot()
        val capture = robot.createScreenCapture(screenRect)
        ImageIO.write(capture, formatName, File(fileName))
    }
}