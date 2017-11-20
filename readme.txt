Timer的基本用法：
	1，Timer的四个任务调度函数的用法（见TimerTest）
	2，Timetask和Timer下的cancel()方法，TimerTask的scheduledExecutionTime()方法，Timer的purge()方法。
		TimerTask下的cancel()方法可以取消当前的task。
		Timer下的cancel()方法可以取消全部的task。
		TimerTask下的scheduledExecutionTime()方法：返回最近发生此task执行安排的时间(为int型，可以使用simpleDateformat.format(...)变为指定格式的时间)。
		Timer的purge()方法作用是从timer任务对列中移除所有已取消的任务。返回移除的任务数量。
	3，Schedule和ScheduleAtFixedTate中的区别：
		a,当首次计划执行时间早于当前时间（见TimerTest2）
			schedule方法："fixed-delay"；如果第一次执行时间被delay了，随后的执行时间按照上一次执行完成的的时间点进行运算。（第一次执行时间为当前时间）	scheduleAtFixedRate方法："fixed-rate";如果第一次执行时间被delay了，随后的执行时间按照上一次应该开始的时间点进行计算，计算缺了多少次没有被计算。(例如timer开启时间2017-11-11 00:00：06，实际计划时间为2017-11-11 00:00：00，晚了6秒钟，并且要求每次间隔2秒钟执行一次task，所以经计算少了3次（00,02,04）,所以当前时间会首先执行3+1（06）=4次，可以通过scheduledExecutionTime()打印出任务的计划执行时间查看效果)并且为了赶上进度会多次执行任务（存在并发性），因此TimerTask中的执行体需要考虑同步。
			
		b,任务执行时间超出当前周期间隔（见TimerTest2）
			schedule方法：下一次执行时间是上一次实际执行完成的时间点，并且计划时间也变为上一次执行完成的时间点！！！(可以通过scheduledExecutionTime()方法查看)。所以任务执行时间会被无限延后。
			视频上说的：scheduleAtFixedRate方法，下一次执行时间相对于上一次开始的时间点，（计划时间不变）因此执行时间一般不会延后，因此存在并发性！！！
			重点：scheduleAtFixedRate方法，下一次执行时间依然为当前执行结束时间，（计划时间不变）！！！！！！！！！！！！！！！！