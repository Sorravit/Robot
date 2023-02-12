package autoClick;

import java.awt.*;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AutoClickerHumanlike {
    Robot robot = new Robot();

    public static void main(String[] args) throws AWTException, InterruptedException {
        new AutoClickerHumanlike();
    }

    public AutoClickerHumanlike() throws AWTException, InterruptedException {
        System.out.println("Auto play in 4 . . .");
        Thread.sleep(1000);
        System.out.println("3 . . .");
        Thread.sleep(1000);
        System.out.println("2 . . .");
        Thread.sleep(1000);
        System.out.println("1 . . .");
        Thread.sleep(1000);
        while (true) {
//			cal = Calendar.getInstance();
//			sdf = new SimpleDateFormat("HH:mm:ss");
//			System.out.println("Initiate auto play " + sdf.format(cal.getTime()));
//			for (int i = 0; i < 442; i++) {
            leftClick();
            Thread.sleep(50);
//			}
//			leftClick();
//			cal = Calendar.getInstance();
//			sdf = new SimpleDateFormat("HH:mm:ss");
//			System.out.println("3 second Break Starting : " + sdf.format(cal.getTime()));
//			Thread.sleep(3000);
        }

    }

    private void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(20);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(20);
    }

    @SuppressWarnings("unused")
    private void moveDown() {
        robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y + 40);
    }

    @SuppressWarnings("unused")
    private void moveUp() {
        robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y - 40);
    }

    @SuppressWarnings("unused")
    private void type(int i) {
        robot.delay(40);
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    @SuppressWarnings("unused")
    private void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
            // robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }
}