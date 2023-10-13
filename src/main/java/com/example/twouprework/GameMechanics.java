package com.example.twouprework;
import java.util.Random;

public class GameMechanics {

    private Random random = new Random();

    public int flipCoin() {
        return random.nextInt(2);
    }

    public String getResultText(int result1, int result2) {
        if (result1 == result2) {
            return result1 == 0 ? "Two Heads!" : "Two Tails!";
        } else {
            return "One of each!";
        }
    }
}
