/**
 * THIS IS A TEST!
 */
package alarm;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;

import sun.font.CreatedFontTracker;
import alarmframe.AlarmWindow;
import aleksPack10.tools.Colors;

/**
 * @author MrabEzreb
 *
 */
public class MainTest {

	/**
	 * @param N/A
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		PopupMenu pop = new PopupMenu("EzrebAlarm");
		MenuItem item1 = new MenuItem("Exit");
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isClosed = true;
				
			}
		};
		item1.addActionListener(l);
		pop.add(item1);
		SystemTray tray = SystemTray.getSystemTray();
		TrayIcon tray2;
		Image image;
		image.
		tray2 = new TrayIcon(image, "Access EzrebAlarm", pop);
		while(isClosed==false) {
			Thread.sleep(1000);
			if(Calendar.getInstance().HOUR_OF_DAY==12 && Calendar.getInstance().MINUTE==53) {
				AlarmWindow win = new AlarmWindow("Lunch is over!");
				win.getWin();
				System.out.println(Colors.orange5);
			}
		}
		
	}
	public static boolean isClosed = false;
}
