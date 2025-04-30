package threadTest;

public class ThreadExample1 {

	public static void main(String[] args) {
		MyThread myThread1 = new MyThread("스래드1");
		MyThread myThread2 = new MyThread("스래드2");
		MyThread myThread3 = new MyThread("스래드3");
		
		myThread1.start();
		myThread2.start();
		myThread3.start();
		
	}

}
