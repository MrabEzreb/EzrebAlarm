/**
 * THIS IS A TEST!
 */
package alarm;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

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
		Image tray3 = new ImageIcon("/EzrebAlarm/src/images/trayIcon2.jpeg").getImage();
		tray2 = new TrayIcon(tray3, "Ezreb Alarm");
		tray2.setImage(tray3);
		System.out.println(tray2.getSize());
		tray2.setPopupMenu(pop);
		tray2.setImageAutoSize(false);
		try {
			tray.add(tray2);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			System.out.println("The EzrebAlarm Tray Icon could not be added to the system tray.");
		}
		while(isClosed==false) {
			Thread.sleep(1000);
			//System.out.println(TimeZone.getDefault());
			//Calendar.getInstance(TimeZone.getDefault());
			//int hour = Calendar.getInstance(TimeZone.getDefault()).HOUR_OF_DAY;
			//int min = Calendar.getInstance(TimeZone.getDefault()).MINUTE;
			//int sec = Calendar.getInstance(TimeZone.getDefault()).SECOND;
			Date d = new Date();
			DateFormat f = new SimpleDateFormat("HHmmss");
			String fo = f.format(d);
			System.out.print(fo);
			if(fo.equals("094700")) {
				System.out.print("It Works!");
			}
			//System.out.println(min);
			//System.out.println(sec);
			/*if(hour==9&&min==44) {
				AlarmWindow win = new AlarmWindow("Lunch is over!");
				System.out.println("Alarm Is Going Off!");
				win.getWin();
				System.out.println(Colors.orange5);
			}*/
		}
		if(isClosed==true) {
			tray.remove(tray2);
		}
	}
	public static boolean isClosed = false;
}
