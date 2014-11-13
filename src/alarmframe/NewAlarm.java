/**
 * 
 */
package alarmframe;

import java.awt.Frame;
import java.awt.TextField;

/**
 * @author MrabEzreb
 *
 */
public class NewAlarm extends CoreWin {

	/**
	 * @param name
	 * @param size
	 */
	public NewAlarm() {
		super("New Alarm", 150);
		Frame win = super.getWin();
		TextField h = new TextField();
		TextField m = new TextField();
		TextField s = new TextField();
		TextField message = new TextField();
		h.setText("Hour");
		m.setText("Minute");
		s.setText("Second");
		message.setText("What to display");
	}

}
