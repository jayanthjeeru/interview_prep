package com.sbi;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import com.commonadapterfw.NEQuarantineStatistics;

public class SbiEventManager {

	public static Map<String, Map<String, Integer>> stats = new ConcurrentHashMap<>();
	
	public static void main(String[] args) {
	//	timer();
	}
	

	public static void timer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("-------------");
				NEQuarantineStatistics n=new NEQuarantineStatistics();
				System.out.println(stats);//send data to consumer topic
//				stats.clear();
			}
		}, 0, 10000);
	}

}
