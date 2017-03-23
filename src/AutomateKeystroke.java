import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.StringTokenizer;

public class AutomateKeystroke {
	Robot robot = new Robot();

	public static void main(String[] args)
			throws AWTException, InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		new AutomateKeystroke();
	}

	public AutomateKeystroke()
			throws AWTException, InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		Thread.sleep(3000);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		for (int i = 0; i < 17; i++) {

			robot.setAutoDelay(100);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			String name = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			StringTokenizer st = new StringTokenizer(name, "/");
			String artist = st.nextToken();
			String title = st.nextToken();
			System.out.println(name + " artist: " + artist + " Title " + title);
			clipboard.setContents(new StringSelection(title), null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_TAB);
			clipboard.setContents(new StringSelection(artist), null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_SHIFT);
		}
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