package dice;

import java.util.Random;
import score.HighScore;

public class Game {

    private String name;
    private int turn = 0;
    private int score = 0;
    public int d1;
    public int d2;
    private boolean finished = false;
    private HighScore hs;
    Random r = new Random();


    public Game(String name) {
        this.name = name;
    }


    public void play() {
        if (turn < 10) {
            d1 = r.nextInt(5) + 1;
            d2 = r.nextInt(5) + 1;
            if ((d1 + d2) == 7) {
                score = score + 10;
            }
            turn++;
        } else {
            hs.addEntry(name, score);
            finished = true;
        }
    }

    @Override
    public String toString() {
        return "name:" + name + ",score:" + score + ",turn:" + turn + ",de1:" + d1 + ",de2:" + d2;
    }

    public boolean isfinished() {
        return finished;
    }

    public HighScore getHs() {
        return hs;
    }

    public void setHs(HighScore hs) {
        this.hs = hs;
    }

        public int getTurn() {
        return turn;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
