import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

public class GenerateFile {
    private static final String[] FIRST_NAME = {
        "John", "Jane", "Michael", "Emily", "David", "Olivia", "Robert", "Sophia",
        "William", "Isabella", "James", "Mia", "Joseph", "Charlotte", "Daniel",
        "Amelia", "Benjamin", "Harper", "Matthew", "Evelyn", "Andrew", "Abigail",
        "Joshua", "Emily", "Ethan", "Elizabeth", "Christopher", "Sofia", "Jacob", "Ava"
    };
    private static final String[] LAST_NAME = {
        "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
        "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
        "Thomas", "Taylor", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson",
        "White", "Harris", "Sanchez", "Clark", "Lewis", "Young", "Hall"
    };
    private static final String[] REASONS = {"Appointment", "Visit"};
    private static final String[] DEPARTMENTS = {"Cardiology","Radiology","Pediatrics", "Geriatrics", "Pulmonology"};
    private static final int NUMBERS_OF_RECORDS = 10;
    private static final Month MONTH = Month.JUNE;

    public static void main (String[] args){
        String filename = "output.csv";

        //Create the CSV file
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write("Firstname,Lastname,Reasons,Departments,Date\n");

            //Pick the random element for the file
            Random random = new Random();
            for (int i = 0; i < NUMBERS_OF_RECORDS; i++) {
                String firstname = getRandomValue(FIRST_NAME, random);
                String lastname = getRandomValue(LAST_NAME, random);
                String reason = getRandomValue(REASONS, random);
                String department = reason.equals("Appointment") ? getRandomValue(DEPARTMENTS, random) : "" ;
                LocalDate date = generateRandomDate(MONTH);

                //Write the elements in the file
                writer.write(firstname+ "," + lastname + "," + reason + "," + department + "," + date + "\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Create the method to pick random elements
    private static String getRandomValue(String[] array, Random random){
        int index = random.nextInt(array.length);
        return array[index];
    }

    //Create the method to pick a random date
    private static LocalDate generateRandomDate(Month month){
        int day = getRandomNumberInRange(1, month.maxLength());
        return LocalDate.of(LocalDate.now().getYear(), month, day);
    }

    //Create the method to generate a random number for the random date
    private static int getRandomNumberInRange(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1 ) +min;
    }
}
