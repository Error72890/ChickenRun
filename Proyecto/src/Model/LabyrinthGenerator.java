package Model;

import java.util.Random;
import Util.CSVWriteReader; 

public class LabyrinthGenerator {
    private static final String[] MAP_POOL = {"DemoLabyData","Map1","Map2","Map3","Map4","Map5","Map6"};
    private static final int LABYRINTHSIZE = 19;
    private short[] labyrinth;
    private final Random random;
    private final CSVWriteReader csvReader;
    
    private void gen(){
        int selectLab = 0;
        
        public LabyrinthGenerator(){
        CSVReader = new CSVWriteReader();
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
    
    public LabyrinthGenerator(){
        csvReader = CSVWriteReader.getInstance();
        random = new Random();
    }
    /*
        0 = empty
        1 = esquina superior izquierda
        2 = paredes superiores
        3 = esquina superior derecha
        4 = paredes derecha
        5 = esquina inferior derecha
        6 = paredes abajo
        7 = esquina inferior izquierda
        8 = paredes izquierda
        9 = paredes interiores
        10 = casillas con maiz
        
        El centro y las esquinas donde van los zorros quedan en 0, todo lo demás que no sea una 
        pared de algún tipo es 10.
    */
    public short[] getNewLabyrinth(){
        randomizeAll();
        return labyrinth;
    }
    
    private void randomizeAll(){
        this.labyrinth = new short[LABYRINTHSIZE * LABYRINTHSIZE];
        int exactMid;
        exactMid = LABYRINTHSIZE/2;
        randomizeChunk(0,exactMid,0,exactMid);
        randomizeChunk(exactMid,LABYRINTHSIZE,0,exactMid);
        randomizeChunk(0,exactMid,exactMid,LABYRINTHSIZE);
        randomizeChunk(exactMid,LABYRINTHSIZE,exactMid,LABYRINTHSIZE);
    }
    private void randomizeChunk(int xMin, int xMax, int yMin, int yMax){
        String mapName = MAP_POOL[random.nextInt(0, MAP_POOL.length)];
        String[][] readedText = csvReader.readFrom("src/Data/"+ mapName + ".txt");
        int x;
        for(x = xMin; x < xMax; x++){
            int y;
            for(y = yMin; y < yMax; y++){
                try{
                    labyrinth[(x*LABYRINTHSIZE)+y] = Short.parseShort(readedText[x][y]);
                }catch(NumberFormatException e){
                    labyrinth[(x*LABYRINTHSIZE)+y] = 9;
                }
            }
        }
    }
}
