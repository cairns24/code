import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;



public class MyTime {
	private static final int count = 10;
	private static Object LOCK = new Object();
	
	private static AtomicReference turn = new AtomicReference();
	public static void main(String[] args){
		
//		transformNs();
//		test();
		test2();
		
	}
	
	public static void transformNs(){
		
	}
	
	static void test(){
		T1 t1 = new T1();
		T1 t2 = new T1();
		t1.other = t2;
		t2.other = t1;
		t1.start();
		t2.start();
		
	}
	static class T1 extends Thread{
		Thread other;
		@Override
		public void run() {
			int i = 1;
			synchronized (LOCK) {
			while(i<count){
				System.out.println(this.getName()+":"+i);
				if(i==count/2){
					LOCK.notify();
					try {
						LOCK.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i = 1;
				}
				i++;
			}
			System.out.println("---");
			}
		}
	}
	private static AtomicLong t = new AtomicLong();
//	private static int t = 0;
	
	static class T2 extends Thread{
		@Override
		public void run() {
			for(int i = 0;i<10;i++){
				t.set(i);
				System.out.println(this.getName()+":"+t);
//				t = i;
			}
			
		}
	}
	
	static class T3 extends Thread{
		@Override
		public void run() {
			for(int i = 10;i<20;i++){
				t.set(i);
				System.out.println(this.getName()+":"+t);
//				t = i;
			}
			
		}
	}
	static void test2(){
		for(int i =0;i<10;i++){
		T2 t1 = new T2();
		T3 t2 = new T3();
		t1.start();
		t2.start();
		}
		
	}
}
