import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AutoClicker {
	Robot robot = new Robot();

	public static void main(String[] args) throws AWTException,
			InterruptedException {
		new AutoClicker();
	}

	public AutoClicker() throws AWTException, InterruptedException {
		System.out.println("Auto play in 4 . . .");
		Thread.sleep(1000);
		System.out.println("3 . . .");
		Thread.sleep(1000);
		System.out.println("2 . . .");
		Thread.sleep(1000);
		System.out.println("1 . . .");
		Thread.sleep(1000);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		
		while (true) {
			cal = Calendar.getInstance();
			sdf = new SimpleDateFormat("HH:mm:ss");
			System.out.println("Initiate auto play "+sdf.format(cal.getTime()));
//			moveDown();
			for (int i = 0; i < 3000; i++) {
				leftClick();
			}
//			moveUp();
			leftClick();
			cal = Calendar.getInstance();
			sdf = new SimpleDateFormat("HH:mm:ss");
			System.out.println("3 second Break Starting : " + sdf.format(cal.getTime()));
			Thread.sleep(3000);
		}
		// ArrayList<Integer> random = new ArrayList<Integer>();
		// while (true) {
		// if(Integer.parseInt(sdf.format(cal.getTime()))==20){
		// type("0");
		// System.out.println(Integer.parseInt(sdf.format(cal.getTime())));
		// }
		// for (int i = 0; i < 5; i++) {
		// random.add(i);
		// }
		// Collections.shuffle(random);
		// for (int i = 0; i < 5; i++) {
		// switch (random.remove(0)) {
		// case 1:
		// type("a");
		// Thread.sleep(1000);
		// break;
		// case 2:
		// type("s");
		// Thread.sleep(1000);
		// break;
		// case 3:
		// type("d");
		// Thread.sleep(1000);
		// break;
		// case 4:
		// type("f");
		// Thread.sleep(1000);
		// break;
		// case 0:
		// type("g");
		// Thread.sleep(1000);
		// break;
		// default:
		// System.out.println("/nSTH wrong");
		// break;
		//
		// }
		// }
		// Thread.sleep(4000);
		// leftClick();
		// }
	}

	private void leftClick() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(20);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(20);
	}

	@SuppressWarnings("unused")
	private void moveDown() {
		robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, MouseInfo
				.getPointerInfo().getLocation().y + 40);
	}

	@SuppressWarnings("unused")
	private void moveUp() {
		robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, MouseInfo
				.getPointerInfo().getLocation().y - 40);
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