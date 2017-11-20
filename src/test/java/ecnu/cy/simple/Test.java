package ecnu.cy.simple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class Test {
	public static void main(String[] args) {
		Timer timer = new Timer();
		DanceTask danceTask = new DanceTask();
		WaterTask waterTask = new WaterTask(danceTask);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sfDateFormat = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
		System.out.print("current time is: "+sfDateFormat.format(calendar.getTime())+"   ");
		
		timer.schedule(danceTask, calendar.getTime(),2000L);
		timer.schedule(waterTask, calendar.getTime(),2000L);
		//System.out.println(timer.purge());
	}
}
