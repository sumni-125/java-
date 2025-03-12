package 자바프로젝트.야구게임;

import java.util.List;

//숫자 판정 로직
class GameJudge {
 public int[] checkNumbers(List<Integer> secret, List<Integer> guess) {
     int strike = 0, ball = 0;
     for (int i = 0; i < 3; i++) {
         if (secret.get(i).equals(guess.get(i))) {
             strike++;
         } else if (secret.contains(guess.get(i))) {
             ball++;
         }
     }
     return new int[]{strike, ball};
 }
}
