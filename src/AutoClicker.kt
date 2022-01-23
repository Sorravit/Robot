import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.MouseInfo
import kotlin.Throws
import java.awt.AWTException
import java.awt.event.KeyEvent
import java.lang.InterruptedException
import kotlin.jvm.JvmStatic
import java.util.Calendar
import java.text.SimpleDateFormat

class AutoClicker {
    var robot = Robot()
    private fun leftClick() {
        println("Left Click")
        robot.mousePress(InputEvent.BUTTON1_MASK)
        robot.delay(20)
        robot.mouseRelease(InputEvent.BUTTON1_MASK)
        robot.delay(20)
    }

    private fun moveDown() {
        robot.mouseMove(
            MouseInfo.getPointerInfo().location.x, MouseInfo
                .getPointerInfo().location.y + 40
        )
    }

    private fun moveUp() {
        robot.mouseMove(
            MouseInfo.getPointerInfo().location.x, MouseInfo
                .getPointerInfo().location.y - 40
        )
    }

    private fun type(i: Int) {
        robot.delay(40)
        robot.keyPress(i)
        robot.keyRelease(i)
    }

    private fun type(s: String) {
        val bytes = s.toByteArray()
        for (b in bytes) {
            var code = b.toInt()
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32
            // robot.delay(40);
            robot.keyPress(code)
            robot.keyRelease(code)
        }
    }

    fun keepScreenAlive() {
        println("Auto play in 4 . . .")
        Thread.sleep(1000)
        println("3 . . .")
        Thread.sleep(1000)
        println("2 . . .")
        Thread.sleep(1000)
        println("1 . . .")
        Thread.sleep(1000)
        var mousePositionX = MouseInfo.getPointerInfo().location.x
        var mousePositionY = MouseInfo.getPointerInfo().location.y
        var oldMousePositionX = MouseInfo.getPointerInfo().location.x
        var oldMousePositionY = MouseInfo.getPointerInfo().location.y
        var cal: Calendar
        var sdf: SimpleDateFormat
        println("Mouse position ($mousePositionX,$mousePositionY}")
        while (true) {
            try {
                mousePositionX = MouseInfo.getPointerInfo().location.x
                mousePositionY = MouseInfo.getPointerInfo().location.y
                println("Mouse position ($mousePositionX,$mousePositionY}")
                println("Old Mouse position ($oldMousePositionX,$oldMousePositionY}")
                if (mousePositionX == oldMousePositionX && mousePositionY == oldMousePositionY) {
                    cal = Calendar.getInstance()
                    sdf = SimpleDateFormat("HH:mm:ss")
                    println("Initiate auto play " + sdf.format(cal.time))
                    leftClick()
                } else {
                    println("Mouse movement detected will not auto click, for now")
                }
                cal = Calendar.getInstance()
                sdf = SimpleDateFormat("HH:mm:ss")
                println("100 second Break Starting : " + sdf.format(cal.time))
                Thread.sleep(100000)
                oldMousePositionX = mousePositionX
                oldMousePositionY = mousePositionY
            } catch (ex: NullPointerException) {
                ex.printStackTrace()
            }
        }
    }
}