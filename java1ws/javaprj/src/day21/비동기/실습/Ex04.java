package day21.비동기.실습;

//2. Runnable 인터페이스를 구현하는 방법(익명으로 구현하는 방법)
public class Ex04 {

	public static void main(String[] args) {
	/*	
		for(int i=0;i<100;i++) {
			System.out.println("하이");
		}
	*/
		//						new Runnable() {} : 익명클래스 만들기
		Thread th1= new Thread( new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					System.out.println("하이");
				}
			}
			
		});
		
		th1.start();
	/*
		for(int i=0;i<100;i++) {
			System.out.println("바이");
		}
	*/
		//					new Runnable() {} = > 익명클래스 작성
		//					new 익명클래스 => 익명클래스로 객체 작성
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					System.out.println("바이");
				}
			}
			
		});
		
		th2.start();
		
	}
}
