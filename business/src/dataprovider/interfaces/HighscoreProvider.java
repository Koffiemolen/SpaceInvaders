package dataprovider.interfaces;

import java.io.File;

public interface HighscoreProvider {

    String getName();

    int getPoints();
    void setPoints(int points);

    void setHighscoreValue(int score);

    void registerNewHighscore(File file, String name);

    void registerNewHighscore(String name);

    String GetHighScore(File file);

    String GetHighScore();
}
