import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class ClickTimeClicker {
	Robot robot = new Robot();

	public static void main(String[] args) throws AWTException, InterruptedException {
		new ClickTimeClicker();
	}

	public ClickTimeClicker() throws AWTException, InterruptedException {
		System.out.println("The robot will start to take over your control in 4 sec");
		Thread.sleep(4000);
		System.out.println("Initiate auto play ");
		ArrayList<Integer> random = new ArrayList<Integer>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		while (true) {
			if (Integer.parseInt(sdf.format(cal.getTime())) == 20) {
				type("0");
				System.out.println(Integer.parseInt(sdf.format(cal.getTime())));
			}
			for (int i = 0; i < 5; i++) {
				random.add(i);
			}
			Collections.shuffle(random);
			for (int i = 0; i < 5; i++) {
				switch (random.remove(0)) {
				case 1:
					type("a");
					Thread.sleep(1000);
					break;
				case 2:
					type("s");
					Thread.sleep(1000);
					break;
				case 3:
					type("d");
					Thread.sleep(1000);
					break;
				case 4:
					type("f");
					Thread.sleep(1000);
					break;
				case 0:
					type("g");
					Thread.sleep(1000);
					break;
				default:
					System.out.println("/nSTH wrong");
					break;

				}
			}
			Thread.sleep(4000);
			activateAll();
		}
	}

	private void activateAll() {
		type("1");
		type("2");
		type("3");
		type("4");
		type("5");
		type("6");
		type("7");
		type("8");
		type("9");
		type("0");

	}

	@SuppressWarnings("unused")
	private void leftClick() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(200);
	}

	@SuppressWarnings("unused")
	private void type(int i) {
		robot.delay(40);
		robot.keyPress(i);
		robot.keyRelease(i);
	}

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