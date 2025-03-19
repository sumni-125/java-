package day21.비동기.실습;

public class Ex03 {

	public static void main(String[] args) {

		// 별도의 흐름으로 만들기(멀티스레드)
		// 2. Runnable 인터페이스를 구현하는 방법

		/*
		 * for(int i=0;i<100;i++) { System.out.println("하이"); }
		 * 
		 * for(int i=0;i<100;i++) { System.out.println("바이"); }
		 */
		
		//				Thread()
		//				Thread(runnable r)
		
		Thread th1 = new Thread ( new C());
		Thread th2 = new Thread(new D());
		
		th1.start();
		th2.start();
		
	}

}

class C implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) { 
			System.out.println("하이"); 
		}
	}
}

class D implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) { 
			System.out.println("바이"); 
		}
	}
	
	
}