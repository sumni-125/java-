package day06;

public class 기본형변수_참조형변수 {

	public static void main(String[] args) {
		
		//프로그램에서 실제적으로 사용되는 데이터 값을 저장하는 변수: 기본형변수
		
		int a=10;	//10점 10원 10도 값 자체
		char b='A';	//'A' 문자 데이터 값 자체
		double c=25.6;	//
		boolean d=true;
		
		
		//기억장소(변수), 상자 => 하나의 값을 기억하는 공간(실제적으로 사용되는 값)
		//
		//참조형변수(기억장소), 상자 한 개 => 주소값(100이라면) 100번지를 의미함
		//100번지에 데이터 있어를 의미함
		
		int[] arr = new int[3];
		
		//1) new에 의해서 int형 3개 공간(메모리)요청
		//2) 확보한 공간의 주소(시작주소)를 반환함
		//3) 참조형 변수가 이 주소를 기억하고 공간에 접근함
		//4) 이 주소값이 사라지면 공간에 접근 할 수 없다
		//5) 공간이 참조를 잃으면 (아무도 기억하는 것이 없다) 가비지가 된다
		//6) 자바는 가비지 컬렉터에 의해 공간이 해제됨
		
		// arr라는 참조형 변수에 있는 주소에 가변 배열이 있다라는 것을 의미함
		
		
		
		
		
	}

}
