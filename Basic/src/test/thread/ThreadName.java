package test.thread;

/**
 * @author weipeng
 * 
 */
public class ThreadName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new Job());
		t.setName("ThreadNameJob");
		t.start();
	}

	static class Job implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
				System.out.println("AAAA");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}