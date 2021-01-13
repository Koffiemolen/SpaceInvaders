package dataprovider.interfaces;

import logic.entities.Highscore;

public interface HighscoreProviderNew {
    Highscore getHighScore();
    void setHighScore(Highscore highscore);
}
