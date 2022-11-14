package Model;

import java.util.Random;

public class LabyrinthGenerator {
    private static final int LABYRINTHSIZE = 19;
    private short[] labyrinth;
    
    /*
        0 = empty;
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
    
    private void generate(){
        short[] newLabyrinth = new short[LABYRINTHSIZE * LABYRINTHSIZE];;
        
        Random random = new Random();
        for(int i=0; i < LABYRINTHSIZE * LABYRINTHSIZE; i++){
            int aux = random.nextInt(0, 3);
            if(aux == 0){
                newLabyrinth[i] = 9;
            }else{
                newLabyrinth[i] = 10;
            }
            if(i < LABYRINTHSIZE){
                newLabyrinth[i] = 2;
            }
            if(i % LABYRINTHSIZE == LABYRINTHSIZE-1){
                newLabyrinth[i] = 4;
            }
            if(i > (LABYRINTHSIZE * LABYRINTHSIZE) - LABYRINTHSIZE - 1){
                newLabyrinth[i] = 6;
            }
            if(i % LABYRINTHSIZE == 0){
                newLabyrinth[i] = 8;
            }
        }    
        newLabyrinth[0] = 1;
        newLabyrinth[LABYRINTHSIZE - 1] = 3;
        newLabyrinth[LABYRINTHSIZE * LABYRINTHSIZE - 1] = 5;
        newLabyrinth[(LABYRINTHSIZE * LABYRINTHSIZE) - LABYRINTHSIZE - 1] = 7;
        newLabyrinth[(LABYRINTHSIZE * LABYRINTHSIZE) / 2 - 1] = 0;

        labyrinth = newLabyrinth;
    }
    
    public short[] getNewLabyrinth(){
        generate();
        return labyrinth;
    }
    
    public short[] getPrefabLabyrinth(){
        short[] levelData= {
            1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,
            8,0,10,10,10,10,10,10,9,10,10,10,10,10,10,10,10,0,4,
            8,10,9,9,9,9,9,10,9,10,9,9,9,9,9,9,9,10,4,
            8,10,10,9,10,10,9,10,9,10,9,10,10,10,10,10,9,10,4,
            8,9,10,10,10,10,10,10,10,10,9,10,9,9,9,10,9,10,4,
            8,9,9,9,9,9,9,9,9,10,10,10,10,10,9,10,9,10,4,
            8,10,10,10,9,10,10,10,10,10,9,9,9,10,9,10,10,10,4,
            8,10,9,10,10,10,9,9,9,10,10,10,10,10,10,10,9,10,4,
            8,10,10,10,9,10,10,10,9,9,9,10,9,9,9,9,9,10,4,
            8,9,9,9,9,9,9,10,10,0,9,10,10,10,10,10,10,10,4,
            8,10,10,10,10,10,9,10,9,10,10,10,9,9,9,9,10,9,4,
            8,10,9,10,9,10,10,10,9,10,9,9,9,10,10,10,10,10,4,
            8,10,9,10,9,9,9,10,9,10,9,10,10,10,9,9,9,10,4,
            8,10,9,10,9,10,10,10,9,10,10,10,9,10,10,10,9,10,4,
            8,10,9,10,9,10,9,10,9,9,9,9,9,10,9,10,9,10,4,
            8,10,9,10,10,10,9,10,10,10,10,10,10,10,9,10,9,10,4,
            8,10,9,9,9,9,9,10,9,9,9,9,9,10,9,10,9,10,4,
            8,0,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,0,4,
            7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,5,
        };
        return levelData;
    }
}
