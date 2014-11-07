/**
 * The window that opens when an alarm goes off.
 */
package alarmframe;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;

import sun.font.Font2D;
import sun.font.FontScaler;
import aleksPack10.tools.Colors;

/**
 * @author MrabEzreb
 */
public class AlarmWindow extends CoreWin {

	public AlarmWindow(String message) {
		super("Alarm", 100);
		Frame win = super.getWin();
		Graphics2D graph = (Graphics2D) win.getGraphics();
		graph.setColor(Colors.red4);
		graph.fillRect(0, 0, 150, 100);
		graph.setColor(Colors.yellow6);
		graph.drawString(message, 5, 50);
		graph.drawLine(0, 50, 150, 50);
		win.setVisible(true);
	}

}
