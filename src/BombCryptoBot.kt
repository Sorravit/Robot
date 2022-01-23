import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube
import java.awt.Color
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.event.InputEvent
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class BombCryptoBot {
    private val robot: Robot = Robot()


    fun oldMain() {
//        Capture screen
//        val screenShot = captureScreen()
//        handleError(screenShot)
        login()

//  Display it
//    DisplayImage().displayImage("screen-capture.png")

        //    Detect Image on screen
//    val locationOfButton = findImageLocation(bufferedImage, ImageIO.read(File("autoClickResource/backButton.png")))
//    val locationOfButton = findImageLocation(bufferedImage, ImageIO.read(File("autoClickResource/newMap.png")))
//    println(locationOfButton)
//    if (locationOfButton != Pair(-1,-1)) {
//        click(locationOfButton)
//    }
//    println(findImageLocation(ImageIO.read(File("screen-capture.png")), ImageIO.read(File("autoClickResource/backButton.png"))))
//    println(findImageLocation(ImageIO.read(File("autoClickResource/test2.png")), ImageIO.read(File("autoClickResource/test3.png"))))
//    println(findImageLocation(ImageIO.read(File("autoClickResource/test.png")), ImageIO.read(File("autoClickResource/test3.png"))))
    }

    private fun handleError(screenShot: BufferedImage) {
        val targetButton = ImageIO.read(File("src/main/resources/button/ok.png"))
        val locationOfButton = findImageLocation(screenShot, targetButton)
        if (locationOfButton == Pair(-1, -1)) {
            println("It's not error . . . yet")
            return
        }
        click(locationOfButton)
    }

    private fun login() {
        var screenShot = captureScreen()
        var targetButton = ImageIO.read(File("src/main/resources/button/connectWallet.png"))
        var locationOfButton = findImageLocation(screenShot, targetButton)
        if (locationOfButton == Pair(-1, -1)) {
            println("Cannot find connect wallet button")
            return
        }
        click(locationOfButton)
//        Thread.sleep(1000)
//        screenShot = captureScreen()
//        targetButton = ImageIO.read(File("src/main/resources/button/metaMask2.png"))
//        locationOfButton = findImageLocation(screenShot, targetButton)
//        if (locationOfButton == Pair(-1, -1)) {
//            println("Cannot find metamask button")
//            return
//        }
//        click(locationOfButton)
        Thread.sleep(1000)
        screenShot = captureScreen()
        targetButton = ImageIO.read(File("src/main/resources/button/sign.png"))
        locationOfButton = findImageLocation(screenShot, targetButton)
        if (locationOfButton == Pair(-1, -1)) {
            println("Cannot find sign button")
            return
        }
        click(locationOfButton)

    }

    fun click(locationOfButton: Pair<Int, Int>) {
        robot.mouseMove(locationOfButton.first, locationOfButton.second)
        leftClick()
        leftClick()
    }

    private fun leftClick() {
        println("Left Click")
        robot.mousePress(InputEvent.BUTTON1_MASK)
        robot.delay(20)
        robot.mouseRelease(InputEvent.BUTTON1_MASK)
        robot.delay(20)
    }

    fun scrollDown() {
        for (i in 1..10) {
            robot.mouseWheel(10)
        }
    }

    fun captureScreen(): BufferedImage {
        val rectangle = Rectangle(Toolkit.getDefaultToolkit().screenSize)
        val bufferedImage = robot.createScreenCapture(rectangle)
        val file = File("screen-capture.png")
        val status = ImageIO.write(bufferedImage, "png", file)
        println("Screen Captured ? " + status + " File Path:- " + file.absolutePath)
        return bufferedImage
    }

    fun findImageLocation(screenShot: BufferedImage, targetedImage: BufferedImage): Pair<Int, Int> {
        for (x in 0 until screenShot.width) for (y in 0 until screenShot.height) {
            var matches = true
            var x2 = 0
            while (x2 < targetedImage.width && matches) {
                var y2 = 0
                while (y2 < targetedImage.height && matches) {
                    if (targetedImage.getRGB(x2, y2) != screenShot.getRGB(x + x2, y + y2)) matches = false
                    y2++
                }
                x2++
            }
            if (matches) {
                return Pair(x, y)
            }
        }
        return Pair(-1, -1)
    }
}