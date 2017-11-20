package ecnu.cy.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import ecnu.cy.timerTask.MyTimerTask;

public class TimerTest {
	public static void main(String[] args) {
		//创建一个Timer实例
		Timer timer = new Timer();
		//创建一个TimerTask实例，这里可以有多个TimerTask实例
		MyTimerTask myTimerTask = new MyTimerTask("cy");
		//通过timer定时定频率调用myTimerTask的业务逻辑
		//即第一次在程序启动两秒后执行，之后每隔3秒执行一次
		//timer.schedule(myTimerTask, 2000L,3000L);
		
		
		//四个定时函数的用法
		
		/**
		 * schedule(TimerTask task, long delay, long period)
		 * 在程序启动delay后执行task，之后每隔period执行一次
		 */
		
		//timer.schedule(myTimerTask, 2000L,3000L);
		
		/**
		 * 获取当前的时间，并设置为三秒后的时间
		 * 如：当前2016-11-10 23:59:57，设置后时间为：2016-11-11 00:00:00
		 */
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sfDateFormat = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
		System.out.println(sfDateFormat.format(calendar.getTime()));
		calendar.add(Calendar.SECOND, 3);
		/**
		 * schedule(TimeTask task, Date time)在时间等于或超过time的时候执行且仅执行一次task
		 */
		//timer.schedule(myTimerTask, calendar.getTime());
		
		/**
		 * schedule(TimerTask task, long delay)
		 * 在程序启动delay后执行task,且只执行一次
		 */
		//timer.schedule(myTimerTask, 2000L);
		
		/**
		 * schedule(TimerTask task, Date firstTime, long period)
		 * 在firstTime第一次执行，之后每隔period执行
		 */
		timer.schedule(myTimerTask, calendar.getTime(),2000L);
		
	}
}
