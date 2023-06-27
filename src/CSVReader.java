import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void main (String[] args){
        String filePath = "src/data.csv";

        try{
            List<CSVLine> csvLines = readCSVFile(filePath);

            //Accessing and printing a particular piece of information
            for (CSVLine line : csvLines){
                System.out.println(line.getName());
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + filePath);
        }
    }
    private static List<CSVLine> readCSVFile(String filePath) throws FileNotFoundException{
        List<CSVLine> csvLines = new ArrayList<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] data = line.split("'");

            String name = data[0];
            String age = data[1];
            String city = data [2];

            CSVLine csvLine = new CSVLine (name,age,city);
            csvLines.add(csvLine);
        }
        scanner.close();
        return csvLines;
    }
}
