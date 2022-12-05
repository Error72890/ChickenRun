package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVWriteReader {
    private static CSVWriteReader instance;
    private final Short MAX_READ_SIZE = 20;

    public String[][] readFrom(String path) {
        String[][] readedData = new String[MAX_READ_SIZE][MAX_READ_SIZE];
        Path filePath = Paths.get(path);
        try ( BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(",");
                readedData[i] = lineData;
                i++;
            }
        } catch (Exception e) {
            readedData = null;
        }
        return readedData;
    }
    
    public void writeTo(String path, String[][] msg){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            int i;
            for(i = 0; i<msg.length; i++){
                String line = "";
                int j;
                for(j = 0; j<msg[0].length; j++){
                    line = line.concat(msg[i][j]);
                    line = line.concat(",");
                }
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.getStackTrace();
        }
    }
    
    private CSVWriteReader(){
    }
    
    public static CSVWriteReader getInstance(){
        if(instance == null){
            instance = new CSVWriteReader();
        }
        return instance;
    }
}
