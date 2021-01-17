package data.providers;

import dataprovider.interfaces.HighscoreProvider;
import logic.entities.Highscore;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase implements HighscoreProvider {
    List<Highscore> highscores = new ArrayList<>();

    // Set all highscores
    @Override
    public void setAllHighScores(List<Highscore> ListHighscores) {
        highscores.clear();
        highscores = ListHighscores;
    }

    // Return all highscores
    @Override
    public List<Highscore> retrieveAllHighScores() {
        return highscores;
    }
}
