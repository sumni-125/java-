package 자바프로젝트.조커뽑기;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class JokerDrawGame {
    private static CardDeck cardDeck;
    private static List<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        cardDeck = new CardDeck();
        cardDeck.shuffle();
        
        int numPlayers = 2;
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("플레이어 " + i));
        }
        
        distributeCards();
        printInitialHands();
        
        for (Player player : players) {
            try {
                removePairs(player);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        try {
            playGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void distributeCards() {
        List<String> deck = cardDeck.getDeck();
        int i = 0;
        for (String card : deck) {
            players.get(i % 2).addCard(card);
            i++;
        }
    }

    private static void printInitialHands() {
        System.out.println("게임 시작! 각 플레이어의 첫번째 패:");
        for (Player player : players) {
            System.out.println(player.getName() + "의 첫번째 패: " + player.getHand());
        }
        System.out.println();
    }

    private static void removePairs(Player player) throws InterruptedException {
        Map<String, List<String>> rankMap = new HashMap<>();
        for (String card : player.getHand()) {
            String rank = getCardRank(card);
            rankMap.putIfAbsent(rank, new ArrayList<>());
            rankMap.get(rank).add(card);
        }
        for (String rank : rankMap.keySet()) {
            List<String> cardsWithSameRank = rankMap.get(rank);
            while (cardsWithSameRank.size() >= 2) {
                String card1 = cardsWithSameRank.remove(0);
                String card2 = cardsWithSameRank.remove(0);
                player.removeCard(card1);
                player.removeCard(card2);
                System.out.println(player.getName() + "가 " + card1 + " 및 " + card2 + " 카드를 버렸습니다.");
                Thread.sleep(1000);
            }
        }
        System.out.println(player.getName() + "의 패 (버린 후): " + player.getHand());
        Thread.sleep(1000);
    }

    private static String getCardRank(String card) {
        return card.substring(card.length() - 1);
    }

    private static void takeCardFromNextPlayer(int currentIndex) throws InterruptedException {
        Player currentPlayer = players.get(currentIndex);
        Player nextPlayer = players.get((currentIndex + 1) % players.size());
        if (!nextPlayer.getHand().isEmpty()) {
            String cardTaken = nextPlayer.getHand().get(0);
            currentPlayer.addCard(cardTaken);
            nextPlayer.removeCard(cardTaken);
            System.out.println(currentPlayer.getName() + "가 " + nextPlayer.getName() + "의 패에서 " + cardTaken + " 카드를 가져와였습니다.");
            removeMatchingCardFromPlayer1(currentPlayer, cardTaken);
        }
        System.out.println(currentPlayer.getName() + "의 패: " + currentPlayer.getHand());
        System.out.println(nextPlayer.getName() + "의 패: " + nextPlayer.getHand());
        Thread.sleep(1000);
    }

    private static void removeMatchingCardFromPlayer1(Player player1, String newCard) {
        Map<String, List<String>> rankMap = new HashMap<>();
        for (String card : player1.getHand()) {
            String rank = getCardRank(card);
            rankMap.putIfAbsent(rank, new ArrayList<>());
            rankMap.get(rank).add(card);
        }
        String newCardRank = getCardRank(newCard);
        List<String> cardsWithSameRank = rankMap.get(newCardRank);
        while (cardsWithSameRank != null && cardsWithSameRank.size() >= 2) {
            String card1 = cardsWithSameRank.remove(0);
            String card2 = cardsWithSameRank.remove(0);
            player1.removeCard(card1);
            player1.removeCard(card2);
            System.out.println(player1.getName() + "가 " + card1 + " 및 " + card2 + " 카드를 버렸습니다.");
        }
    }

    private static void playGame() throws InterruptedException {
        while (players.size() > 1) {
            for (int i = 0; i < players.size(); i++) {
                takeCardFromNextPlayer(i);
                Player currentPlayer = players.get(i);
                if (currentPlayer.getHand().isEmpty()) {
                    System.out.println(currentPlayer.getName() + "이 승리하였습니다.");
                    players.remove(i);
                    i--;
                }
            }
            Thread.sleep(1000);
            List<Player> playersWithJoker = new ArrayList<>();
            for (Player player : players) {
                if (player.getHand().contains("조커")) {
                    playersWithJoker.add(player);
                }
            }
            if (playersWithJoker.size() == 1 && playersWithJoker.get(0).getHand().size() == 1) {
                Player loser = playersWithJoker.get(0);
                System.out.println(loser.getName() + "가 조커 한장만 남겼고 패배했습니다.");
                System.out.println("게임 종료!");
                break;
            }
            System.out.println("\n--- 게임 진행 ---");
        }
    }
}