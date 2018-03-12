package org.meeting.card;

import java.util.Random;

class Card {
    //    花色
    int Suit;
    //    牌的标志
    char Number;
}

public class CardShuffle {
    static Card[] oneCard = new Card[52];

    static void showCard() {
        int i, j;
        int sign = 0;
        String s = "";
        for (i = 0, j = 0; i < 52; i++, j++) {
            if (j % 13 == 0) {
                System.out.print("\n");
            }
            switch (oneCard[i].Suit) {
                case 1:
                    s = "黑桃";
                    sign = 3;
                    break;
                case 2:
                    s = "梅花";
                    sign = 4;
                    break;
                case 3:
                    s = "方块";
                    sign = 5;
                    break;
                case 4:
                    s = "红桃";
                    sign = 6;
                    break;
                default:
                    ;
            }
            System.out.printf("  " + s + oneCard[i].Number);
        }
        System.out.print("\n");
    }

    /**
     * 洗牌
     */
    static void shuffle() {
        int i, j, temp;
        int suit;
        Card tempcard = new Card();
        suit = 0;
        for (i = 0; i < 52; i++) {
            if (i % 13 == 0) {
                suit++;
            }
            Card t = new Card();
            t.Suit = suit;
            temp = i % 13;
            switch (temp) {
                case 0:
                    t.Number = 'A';
                    break;
                case 9:
                    t.Number = '0';
                    break;
                case 10:
                    t.Number = 'J';
                    break;
                case 11:
                    t.Number = 'Q';
                    break;
                case 12:
                    t.Number = 'K';
                    break;
                default:
                    t.Number = (char) (temp + '1');
            }
            oneCard[i] = t;
        }
        System.out.printf("洗牌前:\n");
        showCard();
        Random r = new Random();
        for (i = 0; i < 52; i++) {
            j = r.nextInt(52);
            tempcard = oneCard[j];
            oneCard[j] = oneCard[i];
            oneCard[i] = tempcard;
        }
    }

    public static void main(String[] args) {
        shuffle();
        System.out.print("\n洗牌后:\n");
        showCard();
    }
}
