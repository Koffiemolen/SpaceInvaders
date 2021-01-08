package data.providers;

import dataprovider.interfaces.HighscoreProvider;

import java.io.*;

public class HighscoreStore implements HighscoreProvider {
    private String name;
    private int points;

    public HighscoreStore(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public HighscoreStore() {
        this.name = null;
        this.points = -1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void setHighscoreValue(int score) {
        if (score > this.getPoints()) {
            this.points = score;
        }
    }

    @Override
    public void registerNewHighscore(File file, String name){
        String toFile;
        toFile = name + ":" + this.points;

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

    @Override
    public void registerNewHighscore(String name){
        final File file = new File("highscore.dat");
        String toFile;
        toFile = name + ":" + this.points;

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

    @Override
    public String GetHighScore(File file){
        // format: <user>:<score>
        // format: Bigfoot:125320
        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader(file);
            reader = new BufferedReader(readFile);
            return reader.readLine();
        } catch (Exception exception) {
            // file does not exist or inaccessable
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

    @Override
    public String GetHighScore(){
        final File file = new File("highscore.dat");
        // format: <user>:<score>
        // format: Bigfoot:125320
        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader(file);
            reader = new BufferedReader(readFile);
            return reader.readLine();
        } catch (Exception exception) {
            // file does not exist or inaccessable
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

}
