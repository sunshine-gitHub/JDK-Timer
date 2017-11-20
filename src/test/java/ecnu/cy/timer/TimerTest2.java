package ecnu.cy.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

import ecnu.cy.timerTask.MyTimerTask;

//当出现task计划执行时间早于当前时间schedule和scheduleAtFixedRate的区别
public class TimerTest2 {
	public static void main(String[] args) {
		//创建一个Timer实例
		Timer timer = new Timer();
		//创建一个TimerTask实例，这里可以有多个TimerTask实例
		MyTimerTask myTimerTask = new MyTimerTask("cy");
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sFormat = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
		System.out.println(sFormat.format(calendar.getTime()));
		calendar.add(Calendar.SECOND, -6);
		
		//timer.schedule(myTimerTask, calendar.getTime(),2000L);
		timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(),2000L);
	}
}
