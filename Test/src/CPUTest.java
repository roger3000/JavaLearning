
public class CPUTest {
 
	public static void main(String[] args) {
		CPUTestThread cpuTestThread = new CPUTestThread();
		for (int i = 0;i<8;i++){
			Thread cpuTest = new Thread(cpuTestThread);
			cpuTest.start();
		}
		
		try {
			Runtime.getRuntime().exec("taskmgr");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

class CPUTestThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int busyTime = 10;
		int idleTime = busyTime;
		long startTime = 0;
		while(true){
			startTime=System.currentTimeMillis();
			System.out.println(System.currentTimeMillis()+","+startTime+","+(System.currentTimeMillis()-startTime));
			
			//busy loop
			while((System.currentTimeMillis()-startTime)<=busyTime);
			
			//idle loop
			try {
				Thread.sleep(idleTime);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}
	
}
