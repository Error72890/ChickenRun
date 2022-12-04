package Model;



import java.util.Random;
import Util.CSVWriteReader; 

public class LabyrinthGenerator {
    private static final int LABYRINTHSIZE = 19;
    private short[] labyrinth;
    private CSVWriteReader CSVReader;
        int selectLab = 0;
        
        public LabyrinthGenerator(){
        CSVReader = new CSVWriteReader();
    }
        Random r = new Random();
        short[] levelData = new short[LABYRINTHSIZE*LABYRINTHSIZE];
        selectLab = (int)(Math.random()*6+1);
        if(selectLab == 1){
             String readedText = CSVReader.readFrom("src/Data/Mapa1.txt");
        for(int i=0; i<LABYRINTHSIZE; i++){
            for(int j=0; j<LABYRINTHSIZE; j++){
                levelData[(i*LABYRINTHSIZE)+j] = Short.parseShort(readedText[i][j]);
            }
        }
        return levelData;
        }if(selectLab == 2){
             String readedText = CSVReader.readFrom("src/Data/Mapa2.txt");
        for(int i=0; i<LABYRINTHSIZE; i++){
            for(int j=0; j<LABYRINTHSIZE; j++){
                levelData[(i*LABYRINTHSIZE)+j] = Short.parseShort(readedText[i][j]);
            }
        }
        }if(selectLab == 3){
              String readedText = CSVReader.readFrom("src/Data/Mapa3.txt");
        for(int i=0; i<LABYRINTHSIZE; i++){
            for(int j=0; j<LABYRINTHSIZE; j++){
                levelData[(i*LABYRINTHSIZE)+j] = Short.parseShort(readedText[i][j]);
            }
        }
        }if(selectLab == 4){
             String readedText = CSVReader.readFrom("src/Data/Mapa4.txt");
        for(int i=0; i<LABYRINTHSIZE; i++){
            for(int j=0; j<LABYRINTHSIZE; j++){
                levelData[(i*LABYRINTHSIZE)+j] = Short.parseShort(readedText[i][j]);
            }
        }
        }if(selectLab == 5){
              String readedText = CSVReader.readFrom("src/Data/Mapa5.txt");
        for(int i=0; i<LABYRINTHSIZE; i++){
            for(int j=0; j<LABYRINTHSIZE; j++){
                levelData[(i*LABYRINTHSIZE)+j] = Short.parseShort(readedText[i][j]);
            }
        }
        }if(selectLab == 6){
             String readedText = CSVReader.readFrom("src/Data/Mapa6.txt");
        for(int i=0; i<LABYRINTHSIZE; i++){
            for(int j=0; j<LABYRINTHSIZE; j++){
                levelData[(i*LABYRINTHSIZE)+j] = Short.parseShort(readedText[i][j]);
            }
        }
        }
    }
