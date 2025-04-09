package Day16;
//Method 2: Runnable interface
//Comman sharing task given to differnt threads

class MyRun implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i+" : "+Thread.currentThread().getName());
		}
		
	}
	
}
public class ThreadDemo2 {
	public static void main(String[] args) {
		MyRun r1 = new MyRun();
		
		Thread t1 = new Thread(r1,"T1");
		Thread t2 = new Thread(r1,"T2");
		Thread t3 = new Thread(r1,"T3");
		Thread t4 = new Thread(r1,"T4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}

}
