package threadTest;

public class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i = 0; i < 100 ; i++) {
			System.out.println(getName() + " : " +  i);
			try {
				Thread.sleep(1000); // 1초
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
