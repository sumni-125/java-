package 자바프로젝트.조커뽑기;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<String> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getHand() {
        return hand;
    }

    public void addCard(String card) {
        hand.add(card);
    }

    public void removeCard(String card) {
        hand.remove(card);
    }
    
}
