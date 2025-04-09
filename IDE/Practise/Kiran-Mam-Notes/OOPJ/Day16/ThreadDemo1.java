package Day16;
//Method 1: Thread class extends

class MyThread extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i+" : "+Thread.currentThread().getName());
		}
	}
	
}
public class ThreadDemo1 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("T1");
		MyThread t2 = new MyThread();
		t2.setName("T2");
		MyThread t3 = new MyThread();
		t3.setName("T3");
		MyThread t4 = new MyThread();
		t4.setName("T4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		

	}

}
