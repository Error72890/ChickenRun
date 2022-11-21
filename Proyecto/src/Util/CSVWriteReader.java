package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVWriteReader {
    private Short MAX_READ_SIZE = 20;

    public String[][] readFrom(String path) {
        String[][] readedData = new String[MAX_READ_SIZE][MAX_READ_SIZE];
        Path filePath = Paths.get(path);
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(",");
                readedData[i] = lineData;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readedData;
    }
}
