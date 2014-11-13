package alarm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import alarmframe.AlarmWindow;

public class Alarm {

	public Alarm(String h, String m, String s, String message) {
		this.hour = h;
		this.minute = m;
		this.second = s;
		this.setMessage(message);
		this.full = h+m+s;
	}
	private String hour;
	private String minute;
	private String second;
	private String message;
	public String full;
	/**
	 * @return the message that will show up on the window.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	@SuppressWarnings("unused")
	public void popupAlert() {
		AlarmWindow win = new AlarmWindow(message);
	}
	public void saveAlarm() {
		try (BufferedWriter savefile = Files.newBufferedWriter(FileSystems.getDefault().getPath("data", this.getMessage()+".alarm"), Charset.forName("US-ASCII"));) {
			savefile.write(this.hour);
			savefile.newLine();
			savefile.write(this.minute);
			savefile.newLine();
			savefile.write(this.second);
			savefile.newLine();
			savefile.write(this.message);
			savefile.flush();
			savefile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (BufferedWriter savefile = Files.newBufferedWriter(FileSystems.getDefault().getPath("data", "AlarmNames.txt"), Charset.forName("US-ASCII"));) {
			savefile.append(message);
			savefile.flush();
			savefile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Alarm[] loadAlarms() {
		Alarm[] alarms = new Alarm[500];
		try (BufferedReader list = Files.newBufferedReader(FileSystems.getDefault().getPath("src/data", "AlarmNames.txt"), Charset.forName("US-ASCII"));) {
			String alarm;
			int current = 0;
			while((alarm = list.readLine()) != null) {
				try (BufferedReader alarm1 = Files.newBufferedReader(FileSystems.getDefault().getPath("src/data", alarm+".alarm"), Charset.forName("US-ASCII"));) {
					String h = alarm1.readLine();
					String m = alarm1.readLine();
					String s = alarm1.readLine();
					String message = alarm1.readLine();
					Alarm alarm2 = new Alarm(h, m, s, message);
					alarms[current] = alarm2;
					current++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alarms;
	}

}
