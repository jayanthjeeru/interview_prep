package waste;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Waste {
	public static void main(String[] args) {

//		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Task(),0,60,TimeUnit.SECONDS);

		
		String s = "nna-pmdc   ";
		
		System.out.println(s.strip() + "hi");
		
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("before");
			Thread.sleep(10000);
			checkPortreachability("135.104.219.175", "8980");
			System.out.println("after");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean checkPortreachability(String ipAddress, String nePort) {
		try (Socket socket = new Socket();) {
			InetAddress ip = InetAddress.getByName(ipAddress);
			int port = Integer.parseInt(nePort);
			int timeOut = 15000;
			socket.connect(new InetSocketAddress(ip, port), timeOut);
			System.out.println("GnmiInterfaceWatchDogTask :: checkPortreachability() :: ipAddress " + ipAddress
					+ " with port " + nePort + " is reachable !!!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
