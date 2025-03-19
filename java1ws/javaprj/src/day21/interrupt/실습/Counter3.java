package day21.interrupt.실습;

public class Counter3 extends Thread {

	@Override
	public void run() {
		
		for(int i=10; i>0;i--) {
			
			if(isInterrupted()) {	//isInterrupted() => true or false
									//true => 외부에서 신호가 옴
									//false => 외부에서 신호가 안옴
				System.out.println("인터럽트 발생하여 종료");
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
		
	}
	
	
}
