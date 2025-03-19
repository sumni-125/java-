package day21.sleep.실습;

public class Ex01 {

	public static void main(String[] args) {

		System.out.println("3초후에 공개");

		// sleep (스레드 일시정지) 일시정지 큐에 들어감
		// 지정된 시간이 지나면 다시 실행 가능한 상태( 실행대기열에 들어감 )

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("짜잔~ 축하 ^^ 홍길동님");

	}

}
