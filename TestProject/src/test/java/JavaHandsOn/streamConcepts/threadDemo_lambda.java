package JavaHandsOn.streamConcepts;

public class threadDemo_lambda {

	/**
	 * here we are creating thread using lambda and annonymous class
	 */
	public static void main(String[] args) {
	    
		/* conventional way of creating thread*/
		MyThread mythread = new MyThread();
		Thread t = new Thread(mythread);
		t.start();
		/* thread using annonymous class and lambda expression */
		Runnable r = () -> System.out.println(Thread.currentThread().getName() + "___");
		Thread t3 = new Thread(r);
		t3.start();

	}
}

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("atul");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}

	}
}
