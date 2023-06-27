import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingLetters {
    public static void main(String[] args){
        String filePath = "src/test.txt";

        //Create a map to store letters
        Map<Character, Integer> lettersCounts = new HashMap<>();

        try{
            //Read the file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            //Process each line
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                // Split the line into individual letters
                char[] letters = line.toCharArray();

                // Count the occurrence of each letters
                for (char letter : letters) {
                    lettersCounts.put(letter, lettersCounts.getOrDefault(letter, 0) + 1 );
                }
            }
            // Print the letter counts
            for (Map.Entry<Character, Integer> entry : lettersCounts.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(("File not found: " + filePath));
        }
    }
}
