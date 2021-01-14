package dataprovider.interfaces;

import java.io.File;

public interface HighscoreProvider {

    String getName();
    int getPoints();
    void setPoints(int points);
    void setHighscoreValue(int score);
    void registerNewHighscore(String name, int score);
    String GetHighScore();

}
