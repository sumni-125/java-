package 자바프로젝트.main; // MainPage는 main 패키지에 있음

import java.util.List;
import java.util.Scanner;

import 자바프로젝트.Login.Login;
import 자바프로젝트.Login.User;
import 자바프로젝트.Login.UserFileReader;
import 자바프로젝트.세븐카드게임.Main;
import 자바프로젝트.야구게임.NumberBaseballGame;
import 자바프로젝트.조커뽑기.JokerDrawGame;
import 자바프로젝트.카드뒤집기.카드뒤집기게임;

public class MainPage0312 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<User> users = UserFileReader.loadUsers();
		int coins = Login.login(); // 로그인 하는 메서드, 로그인 성공하면 코인 개수 반환.
		User currentUser = users.get(0);

		loop: while (true) {
			if (coins <= 0) {
				System.out.println("게임을 시작하려면 코인을 넣어주세요 (최소 1개 필요)");
				coins = sc.nextInt();

				currentUser.setCoin(coins);
				continue;
			}

			System.out.println("남은 코인: " + coins);
			System.out.println("1.조커뽑기, 2.숫자야구, 3.카드뒤집기, 4.세븐포커, 5., 6.종료");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				// 1번을 선택하면 조커뽑기 게임 실행
				JokerDrawGame.main(new String[] {}); // JokerDrawGame의 main 메소드 호출
				coins--;
				currentUser.setCoin(coins);// 게임한판 할때마다 코인1개씩 감소
				break;

			case 2:
				NumberBaseballGame baseballGame = new NumberBaseballGame();
				baseballGame.start(); // NumberBaseballGame의 start 메소드 호출
				coins--;
				currentUser.setCoin(coins);
				break;

			case 3:
				카드뒤집기게임.main(new String[] {}); // JokerDrawGame의 main 메소드 호출
				coins--;
				currentUser.setCoin(coins);
				break;

			case 4:
				Main.main(new String[] {}); // 세븐포커의 main 메소드 호출
				coins--;
				currentUser.setCoin(coins);
				break;

			case 5:

				break;

			case 6:
				// 6번을 선택하면 종료
				System.out.println("게임을 종료합니다.");
				break loop;

			default:
				// 잘못된 입력 처리
				System.out.println("메뉴가 잘못 입력되었습니다.");
			}
		}

		sc.close(); // Scanner 자원 반환
	}
}
/*




*/