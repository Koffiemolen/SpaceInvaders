package data.providers;


import dataprovider.interfaces.HighscoreProviderNew;
import logic.entities.Highscore;

import java.io.*;

public class HighscoreStoreNew implements HighscoreProviderNew {

    File file = new File("highscore.dat");
    Highscore highscore = new Highscore();

    public HighscoreStoreNew() {

    }

    public HighscoreStoreNew(Highscore highscore) {
    }


    public Highscore getHighScore(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException event){
                event.printStackTrace();
            }
        }
        FileWriter writeFile;
        BufferedWriter writer = null;
        return retrieveHighScoreFromFile();
    }


    @Override
    public void setHighScore(Highscore highscore){
        final File file = new File("highscore.dat");
        // Filtering variable name and allow only aplhanumerical characters.
        // With no filtering users are able to cheat the highscore by adding : to their name and a highscore
        // Example Bertje:999999 would become Bertje:999999:1200
        String toFile = highscore.getName().replaceAll("[^A-Za-z0-9 ]", "") + ":" + highscore.getScore();

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException event){
                event.printStackTrace();
            }
        }
        FileWriter writeFile;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(file);
            writer = new BufferedWriter(writeFile);
            writer.write(toFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Highscore retrieveHighScoreFromFile(){
        // format: <user>:<score>
        // format: Bigfoot:125320
        Highscore highscore = new Highscore();
        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader(file);
            reader = new BufferedReader(readFile);
            return convertStringToHighscore(reader.readLine());
        } catch (Exception exception) {
            // file does not exist or inaccessible
            return highscore;
        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Highscore convertStringToHighscore(String readLine){
        Highscore highscore = new Highscore();

        if(!readLine.isEmpty()){
            String name = readLine.split(":")[0];
            int score = (Integer.parseInt(readLine.split(":")[1]));
            highscore.setName(name);
            highscore.setScore(score);
        }
        return highscore;
    }
}
