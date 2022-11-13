package Model;

public class LabyrinthGenerator {
    private int fila=0;
    private int columna=0;
    private final int numeroFilas=19;
    private final int numeroColumnas=19;
    private final int anchoBloque=40;
    private final int altoBloque=40;
    
    public void paint(Graphics grafico){
        int[][]laberinto=obtieneLaberinto();
        for(fila=0; fila<numeroFilas; fila++){
            for(columna=0; columna<numeroColumnas;columna++){
                if(laberinto[fila][columna]==1){
                    grafico.setColor(Color.blue);
                    grafico.fillRect(columna*40,fila*40,anchoBloque, altoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40,fila*40,anchoBloque, altoBloque);
                }
            }
        }
    }
    
    public int[][] obtieneLaberinto(){
        int laberinto[][]=
        {{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
         { 1,2,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,2,1},
         { 1,0,0,1,0,0,0,0,0,0,1,0,1,1,1,1,0,0,1},
         { 1,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1},
         { 1,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,0,1},
         { 1,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,1},
         { 1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1},
         { 1,0,0,1,0,0,1,1,0,1,0,1,0,1,0,1,0,0,1},
         { 1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
         { 1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1},
         { 1,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,1},
         { 1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1},
         { 1,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
         { 1,0,0,0,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1},
         { 1,0,0,1,0,0,1,0,1,0,1,1,1,0,0,0,0,0,1},
         { 1,0,1,1,1,1,1,1,1,0,0,0,0,0,1,0,1,0,1},
         { 1,0,0,0,0,0,1,1,0,0,1,1,1,1,1,0,0,0,1},
         { 1,2,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,2,1},
         { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   
        };
        return laberinto;
    }
}
