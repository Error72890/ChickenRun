package Util;

public class CSVWriteReader {
    public String[] readFrom(String path){
        //Some code
                    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>> ();
            Path filePath = Paths.get("data");
            try {
                BufferedReader br = Files.newBufferedReader(filePath);
                        String line;
                        while ((line = br.readLine())!=null){
                String[] lineData = line.split(",");   
                ArrayList<String> temporaldata = new ArrayList<String>();
            }
            }catch (IOException e){
                e.printStackTrace();
            }
        int lineQuantity = 3; //Dinamic increment
        String[] readedText = new String[lineQuantity];
        return readedText;
    }
}
