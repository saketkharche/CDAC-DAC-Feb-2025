package Day16;
//sleep(): introduce delay to stagger execution

class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i+" : "+Thread.currentThread().getName());
			
		}
		System.out.println(Thread.currentThread().getName()+"Sleeeping......");
		try {
			Thread.sleep(10000);//throws an exception e
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"Awaking and work done......");
		
	}
	
}
public class ThreadDemo6 {

	public static void main(String[] args) { 
		System.out.println(Thread.currentThread().getName()+" Started");
		
		MyThread2 t1 = new MyThread2();
		MyThread2 t2 = new MyThread2();
		MyThread2 t3 = new MyThread2();
		MyThread2 t4 = new MyThread2();
		
		t1.start();
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		t2.start();
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		t3.start();
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		t4.start();
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+" Finished");
	
		
			
	}

}
