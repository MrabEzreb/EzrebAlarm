/**
 * Starts EzrebAlarm
 */
package alarm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MrabEzreb
 *
 */
public class Main {

	public static Alarm[] alarms = new Alarm[500];
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		AlarmTray.add();
		alarms = Alarm.loadAlarms();
		while(AlarmTray.isClosed==false) {
			Thread.sleep(1000);
			Date d = new Date();
			DateFormat f = new SimpleDateFormat("HHmmss");
			String fo = f.format(d);
			System.out.println(fo);
			System.out.println(alarms[0].full);
			int current = 0;
			Alarm al = null;
			while(alarms[current] != null) {
				al = alarms[current];
				if(fo.equals(al.full)) {
					al.popupAlert();
				}
				current++;
			}
			
		}
		if(AlarmTray.isClosed==true) {
			AlarmTray.tray.remove(AlarmTray.tray2);
		}

	}

}