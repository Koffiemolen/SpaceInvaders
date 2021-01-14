package data.providers;

import dataprovider.interfaces.HighscoreProvider;
import logic.entities.Highscore;

import java.util.ArrayList;

public class MockDatabase implements HighscoreProvider {
    private ArrayList<Highscore> highscores = new ArrayList<>();


    @Override
    public String getName() {
        return null;
    }

    // highscores kunnen opslaan


    // alle highscores ophalen


    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public void setPoints(int points) {

    }

    @Override
    public void setHighscoreValue(int score) {

    }

    @Override
    public void registerNewHighscore(String name, int score) {

    }

    @Override
    public String GetHighScore() {
        return null;
    }
}
