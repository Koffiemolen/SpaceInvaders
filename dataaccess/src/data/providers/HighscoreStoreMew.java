package data.providers;


import dataprovider.interfaces.HighscoreProviderNew;
import logic.entities.Highscore;

import java.io.*;

public class HighscoreStoreMew implements HighscoreProviderNew {

    File file = new File("highscore.dat");

    public HighscoreStoreMew() {
    }

    public HighscoreStoreMew(Highscore highscore) {
    }

//    public Highscore getHighScore(Highscore highscore){
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException event){
//                event.printStackTrace();
//            }
//        }
//        FileWriter writeFile;
//        BufferedWriter writer = null;
//        try {
//            writeFile = new FileWriter(file);
//            writer = new BufferedWriter(writeFile);
//            writer.write(highscore.getName() + ":" + highscore.getScore());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if(writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    @Override
    public Highscore getHighScore() {
        return null;
    }

    @Override
    public void setHighScore(Highscore highscore) {

    }


    public void registerNewHighscore(String name, int score){
        final File file = new File("highscore.dat");
        // Filtering variable name and allow only aplhanumerical characters.
        // With no filtering users are able to cheat the highscore by adding : to their name and a highscore
        // Example Bertje:999999 would become Bertje:999999:1200
        String toFile = name.replaceAll("[^A-Za-z0-9 ]", "") + ":" + score;

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

    private String retrieveHighScoreFromFile(){
        // format: <user>:<score>
        // format: Bigfoot:125320
        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader(file);
            reader = new BufferedReader(readFile);
            return reader.readLine();
        } catch (Exception exception) {
            // file does not exist or inaccessible
            return "0";
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
        String name = readLine.split(":")[0];
        int score = (Integer.parseInt(readLine.split(":")[1]));

        Highscore highscore = new Highscore(name, score);
        return highscore;
    }
}
