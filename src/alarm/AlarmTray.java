/**
 * 
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

import javax.swing.ImageIcon;

/**
 * @author MrabEzreb
 *
 */
public class AlarmTray {
	public static boolean isClosed = false;
	public static TrayIcon tray2;
	public static SystemTray tray = SystemTray.getSystemTray();
	public static Alarm newAlarm = null;
	public static void add() {
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
	}
}
