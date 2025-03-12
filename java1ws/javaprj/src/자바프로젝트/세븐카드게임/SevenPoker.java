package 자바프로젝트.세븐카드게임;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class SevenPoker {

	
	String [][] card = {
			{"1♥", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥"},
			{"1♦", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦"},
			{"1♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣"},
			{"1♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠"}
		};
	
	
	Random random = new Random();
	
	
	
	//생성자
	public SevenPoker() {
		// TODO Auto-generated constructor stub
	}
	
	public void RandomCard() {
		
	}
	
	//룰 출력부분
	public void Rule() {
		try (BufferedReader bf = new BufferedReader(new FileReader("res/SevenPokerRule.txt"))){

			while(true) {
				String rule = bf.readLine();
				
				if(rule == null) break;
				
				System.out.println(rule);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getCardValue (String card) {
		 String numberPart = card.substring(0, card.length() - 1); // 마지막 문자(♥, ♦, ♣, ♠) 제거

	        switch (numberPart) {
	            case "J": return 11;
	            case "Q": return 12;
	            case "K": return 13;
	            default: return Integer.parseInt(numberPart);
	        }
	}

	
	
	
	
	
}
