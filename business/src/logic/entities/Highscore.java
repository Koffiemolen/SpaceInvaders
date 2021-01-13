package logic.entities;

public class Highscore {

    private String name;
    private int highscore;

    public Highscore(String name, int score) {
        this.name = name;
        this.highscore = score;
    }

    public Highscore(Highscore highscore){
        this.name = highscore.name;
        this.highscore = highscore.highscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // User input for name can be anything.
        // Filtering out all non-alphanumerical characters
        this.name = name.replaceAll("[^A-Za-z0-9 ]", "");
    }

    public int getScore() {
        return highscore;
    }

    public void setScore(int score) {
        this.highscore = score;
    }

    public void setHighscoreValue(int score) {
        if (score > this.getScore()) {
            this.highscore = score;
        }
    }


}
