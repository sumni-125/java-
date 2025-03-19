package day21.interrupt.실습;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Counter2 c = new Counter2();
		c.start();
		
		System.out.println(c.isInterrupted());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.interrupt();
		System.out.println(c.isInterrupted());
		
	}

}
