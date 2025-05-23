package Day16;

public class ThreadDemo10 extends Thread{
	static ThreadDemo10 d3 = new ThreadDemo10();
	static ThreadDemo10 d4 = new ThreadDemo10();
	
synchronized void m1() {
	System.out.println(Thread.currentThread().getName()+" started-m1");
	try {Thread.sleep(1000);}catch(InterruptedException e) {}
	
	synchronized (d3) {
		System.out.println("Locked !!");
	}
	System.out.println(Thread.currentThread().getName()+" finished-m1");
}

synchronized void m2() {
	System.out.println(Thread.currentThread().getName()+" started-m1");
	try {Thread.sleep(1000);}catch(InterruptedException e) {}
	synchronized (d3) {
		System.out.println("Locked !!");
	}
	System.out.println(Thread.currentThread().getName()+" finished-m1");
}
	
	public static void main(String[] args) {
		
		ThreadDemo10 d1 = new ThreadDemo10();
		ThreadDemo10 d2 = new ThreadDemo10();
		
		Thread t1 = new Thread() {
			public void run() {
				d3.m1();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
			
					d4.m2();
			}
			};
			
			t1.setName("T1");
			t2.setName("T2");
			t2.start();
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			t1.start();
		
		}

}
