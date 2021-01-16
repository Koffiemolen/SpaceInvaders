package data.providers;

import dataprovider.interfaces.HighscoreProvider;
import logic.entities.Highscore;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase implements HighscoreProvider {
    private ArrayList<Highscore> highscores = new ArrayList<>();


    // highscores kunnen opslaan


    // alle highscores ophalen

    @Override
    public void setAllHighScores(List<Highscore> ListHighscores) {

    }

    @Override
    public List<Highscore> retrieveAllHighScores() {
        return null;
    }
}
