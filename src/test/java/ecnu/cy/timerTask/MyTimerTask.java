package ecnu.cy.timerTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
	
	private String name;
	
	public MyTimerTask(String name) {
		this.name = name;
	}

	//里面是业务逻辑
	@Override
	public void run() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sfDateFormat = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
		System.out.print("current time is: "+sfDateFormat.format(calendar.getTime())+"   ");
		System.out.println("current exec TimerTask name is： "+name);
	}

}
