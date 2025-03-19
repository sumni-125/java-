package day21.join.실습;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Counter th = new Counter ();
		th.start();
		
		//시간끌기
		//작업수행흉내
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			th.join();	// th 스레드 작업이 끝날때까지 기다리기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메인프로그램 종료");
	}

}
