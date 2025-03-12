package 자바프로젝트.야구게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//컴퓨터가 랜덤 숫자 생성
public class Computer {
    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        while (numbers.size() < 3) {
            int num = rand.nextInt(9) + 1; // 1~9 랜덤 숫자
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }
}
