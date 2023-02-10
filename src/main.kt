import autoClick.AutoClicker
import notification.LineNotification
import util.ScreenshotUtil
import java.io.FileInputStream
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

const val screenShotName = "screenShot.png"
fun main(args: Array<String>) {
    val properties = Properties()
    val screenshotUtil = ScreenshotUtil()
    properties.load(FileInputStream("config.properties"))
    val line = LineNotification(properties.getProperty("token"))
    val executorService = Executors.newSingleThreadScheduledExecutor()

    executorService.scheduleAtFixedRate({
        screenshotUtil.takeScreenshot(screenShotName)
        println(
            "Line message Sending Status: " + line.send(
                "Current Screenshot",
                picture = screenShotName
            ).responseCode
        )
    }, 0, 1, TimeUnit.HOURS)

    AutoClicker().keepScreenAlive()
}
