package ecnu.cy.simple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class DanceTask extends TimerTask{

	@Override
	public void run() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sfDateFormat = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
		System.out.print("current time is: "+sfDateFormat.format(calendar.getTime())+"   ");
		System.out.println("I am dancing");
	}

}
