package autoClick;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseRecorder implements MouseListener {
	public static void main(String[] args) {
		new MouseRecorder();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		System.out.println(b);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		System.out.println(b);


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
