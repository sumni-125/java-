package day21.join.실습;

public class Ex02 {

	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		
		a.start();
		b.start();
		
		//메인스레드의 작업이 진행
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		try {
			a.join();	//a스레드 작업이 완료될 때까지 기다리기
			b.join();	//b스레드 작업이 완료될 때까지 기다리기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int total = a.getSum()+b.getSum();
		
		System.out.println("프로그램 종료 "+total);

	}

}
