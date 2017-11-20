package ecnu.cy.simple;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class WaterTask extends TimerTask{
	private int cap = 5;
	private int count = 0;
	private DanceTask danceTask;
	public WaterTask(DanceTask danceTask) {
		this.danceTask = danceTask;
	}
	
	//若是想知道取消的task数量，需要传进来timer对象。
	@Override
	public void run() {
		if (count<cap) {
			System.out.println("water task .....");
			count++;
		}else{
			cancel();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			danceTask.cancel(); //传进来timer对象，调用timer.cancel()也可以取消danceTask
		}
	}
}
