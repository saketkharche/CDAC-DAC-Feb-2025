package Day16;
//Execution of join(): To take the controll of execution

class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i+" : "+Thread.currentThread().getName());
			
		}
	}
	
}
public class ThreadDemo5 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" started");
		MyThread1 t1 = new MyThread1();t1.setName("T1");
		MyThread1 t2 = new MyThread1();t2.setName("T2");
		MyThread1 t3 = new MyThread1();t3.setName("T3");
		MyThread1 t4 = new MyThread1();t4.setName("T4");
		
		t1.start();
		t2.start();
		t3.start();
		
		//join(): ensures t3 thread completes before t4
		try {
			t3.join();// throws exception e
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Executed!");
		}
		
		t4.start();
		
		
		
		System.out.println(Thread.currentThread().getName()+" Finished");
		

	}

}
