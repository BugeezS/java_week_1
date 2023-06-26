import java.util.Random;

public class RandomIntArrayExample {
    public static void  main (String[] args) {
        int maxSize = 10;
        int[] randomArray = generateRandomArray(maxSize);
        System.out.println("Random Array: ");
        for (int num : randomArray){
            if(num < 10){
                System.out.println(num);
            }
        }
    }
    private static int[] generateRandomArray(int maxSize){
        int [] array = new int[maxSize];
        Random random = new Random();

        for(int i = 0; i < maxSize; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}