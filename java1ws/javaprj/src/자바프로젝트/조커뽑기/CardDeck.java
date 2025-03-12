package 자바프로젝트.조커뽑기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<String> deck;

    public CardDeck() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    // 카드덱 초기화
    private void initializeDeck() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        // 카드덱에 추가
        for (String suit : suits) {	//suit가 ♠, ♥, ♦, ♣ 순으로 변경됨.
            for (String rank : ranks) {
                deck.add(suit + rank);
            }
        }

        // 조커 추가
        deck.add("조커");
    }

    // 카드 섞기
    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<String> getDeck() {
        return deck;
    }
    
}
