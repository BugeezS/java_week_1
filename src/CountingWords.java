import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingWords {
    public static void main(String[] args){
        String filepath = "src/test.txt";

        //Create a map to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        try{
            //Read the file
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            //Process each line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //Split the line into words
                String[] words = line.split("\\s+");

                //Count the occurrence of each word
                for (String word : words) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }

            //Print the word counts
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found: " + filepath);
        }
    }
}
