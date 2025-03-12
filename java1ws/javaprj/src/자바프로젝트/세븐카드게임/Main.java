package 자바프로젝트.세븐카드게임;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		SevenPokerComputer com = new SevenPokerComputer();
		SevenPokerUser user = new SevenPokerUser();
		SevenPoker sp = new SevenPoker();

		// 룰 설명
//		sp.Rule();

		loop: while (true) {

			System.out.println("세븐 카드게임에 오신걸 환영합니다.");
			System.out.println("1. 룰 설명, 2. 게임시작, 3. 종료");

			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				sp.Rule();
				System.out.println();
				break;

			case 2:
				System.out.println("게임을 시작하겠습니다.");
				System.out.println("딜러의 카드가 생성되었습니다.");
				com.RandomCard();
				System.out.println("유저의 카드가 생성되었습니다.");
				user.RandomCard();

				boolean gameOver = false;
				while (!gameOver) {

					System.out.println("1. 카드뽑기");
					int addCard = sc.nextInt();

					switch (addCard) {
					case 1:
						
						//딜러 카드 추가
						boolean dealer = com.Ascending();
						boolean userA = user.Ascending();
//						 boolean usere = user.Ascending();
						
						//사용자 카드 사용확인
						if(userA) {
							System.out.println("유저의 승리입니다.");
							gameOver = true;
						} else if(dealer){
							System.out.println("딜러의 승리입니다.");
							gameOver = true;
						}else {
								System.out.println("유저의 카드를 1장 뽑습니다.");
								user.CardAdd();
								System.out.println();
								System.out.println("딜러가 카드를 1장 뽑습니다.");
								com.CardAdd();
							}
						
//						if(userA == dealer) {
//							System.out.println("카드를 다시 뽑습니다.");
//						}
						break;
					}
				}

			case 3:
				System.out.println("게임을 종료하겠습니다.");
				break loop;
			}
		}

	}

}
