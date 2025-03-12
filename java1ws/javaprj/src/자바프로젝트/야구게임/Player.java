package 자바프로젝트.야구게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {
    private final Scanner scanner = new Scanner(System.in);
    
    public List<Integer> getUserInput() {
        System.out.print("숫자 3개를 입력하세요 (1~9, 중복X): ");
        while (true) {
            String input = scanner.nextLine();
            List<Integer> guess = parseInput(input);
            if (guess != null) return guess;
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }
    }
    
    private List<Integer> parseInput(String input) {
        // 3자리 숫자 입력을 받는 경우
        if (input.length() == 3) {
            List<Integer> numbers = new ArrayList<>();
            try {
                // 각 자리를 하나씩 분리해서 숫자로 변환
                for (int i = 0; i < 3; i++) {
                    int num = Integer.parseInt(String.valueOf(input.charAt(i)));
                    if (num < 1 || num > 9 || numbers.contains(num)) return null; // 1~9 범위, 중복 검사
                    numbers.add(num);
                }
                return numbers;
            } catch (NumberFormatException e) {
                return null; // 숫자가 아닌 값이 입력되었을 경우
            }
        }
        return null; // 3자리 숫자가 아닌 경우
    }
}
