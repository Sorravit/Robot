import autoClick.AutoClicker
import notification.LineNotification
import util.ScreenshotUtil
import java.io.FileInputStream
import java.util.*

const val screenShotName="screenShot.png"
fun main(args: Array<String>) {
    AutoClicker().keepScreenAlive()
//
//    val properties = Properties()
//    val screenshotUtil = ScreenshotUtil()
//    properties.load(FileInputStream("config.properties"))
//    val line = LineNotification(properties.getProperty("token"))
//
//    screenshotUtil.takeScreenshot(screenShotName)
//    println(line.send("Current Screenshot", picture = screenShotName).inputStream.bufferedReader().use { it.readText() })

}
