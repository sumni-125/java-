package day14.인터페이스실습_teamproject_권지언이수민;

public class Americano implements Order {

	@Override
	public String Order() {
		String menu = "아메리카노";
		return menu;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 1500;
	}

}
