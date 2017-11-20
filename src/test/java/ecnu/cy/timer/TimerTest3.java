package ecnu.cy.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import ecnu.cy.timerTask.MyTimerTask;

//任务执行时间超出当前周期间隔schedule和scheduleAtFixedRate的区别
public class TimerTest3 {
	public static void main(String[] args) {
		//创建一个Timer实例
		Timer timer = new Timer();
		
		
		Calendar calendar = Calendar.getInstance();
		//SimpleDateFormat sFormat = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
		//System.out.println(sFormat.format(calendar.getTime()));
		
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				Calendar calendar = Calendar.getInstance();
//				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				System.out.print("real exec time is :"+sFormat.format(calendar.getTime()));
//				System.out.println("  scheduled exec time is :"+sFormat.format(scheduledExecutionTime()));
//
//				try {
//					Thread.sleep(3000); //让task执行时间变为3秒
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}, calendar.getTime(),2000L);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.print("real exec time is :"+sFormat.format(calendar.getTime()));
				System.out.println("  scheduled exec time is :"+sFormat.format(scheduledExecutionTime()));

				try {
					Thread.sleep(3000); //让task执行时间变为3秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, calendar.getTime(),2000L);
	}
}
