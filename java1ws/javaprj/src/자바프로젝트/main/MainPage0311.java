package  자바프로젝트.main; // MainPage는 main 패키지에 있음

import java.util.Scanner;

import 자바프로젝트.야구게임.NumberBaseballGame;
import 자바프로젝트.조커뽑기.JokerDrawGame;
import 자바프로젝트.카드뒤집기.카드뒤집기게임;

public class MainPage0311 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("1.조커뽑기, 2.숫자야구, 3.카드뒤집기 , 4, , 6.종료");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    // 1번을 선택하면 조커뽑기 게임 실행
                    JokerDrawGame.main(new String[]{}); // JokerDrawGame의 main 메소드 호출
                    break;

                case 2:
                	NumberBaseballGame baseballGame = new NumberBaseballGame();
                    baseballGame.start(); // NumberBaseballGame의 start 메소드 호출
                    break;

                case 3:
                	카드뒤집기게임.main(new String[]{}); // JokerDrawGame의 main 메소드 호출
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
