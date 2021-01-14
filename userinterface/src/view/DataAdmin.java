package view;

import data.providers.HighscoreStore;
import logic.entities.Highscore;

import java.util.ArrayList;
import java.util.List;

public class DataAdmin {
    ArrayList<Highscore> highscore = new ArrayList<>();
    private HighscoreStore highscoreStore;

    public DataAdmin(HighscoreStore highscoreStore) {
        this.highscoreStore = highscoreStore;
    }

    public List<Highscore> retrieveAllHighscores(){
        return  highscoreStore.retrieveAllHighscore();
    }
}
