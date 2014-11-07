/**
 * The class that controls the main window.
 * This class is a superclass that creates a window, so it can be subclassed to do whatever you want.
 */
package alarmframe;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import alarm.MainTest;

/**
 * @author Mrab Ezreb
 */
public class CoreWin {
	public CoreWin(String name, int size) {
		win.setName(name);
		win.setSize(size, size);
		win.setResizable(false);
		win.setVisible(true);
		win.addWindowListener(l);
	}
	private Frame win = new Frame();
	/**
	 * @return The main window
	 */
	public Frame getWin() {
		return win;
	}
	WindowListener l = new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			win.setVisible(false);
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			win.setVisible(true);
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			win.dispose();
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			MainTest.isClosed = true;
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	};

}
