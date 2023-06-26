import java.util.Random;

public class DivisionArrayExample {
    public static void main (String[] args){
        int maxSize = 10;
        int [] randomArray = generateRandomArray(maxSize);

        System.out.println("Random Array: ");
        for (int i = 0; i < randomArray.length; i++){
            if (i==0 || randomArray[i - 1] == 0){
                System.out.println(randomArray[i] + "Cannot divide");
            }else{
                double result = (double) randomArray[i] / randomArray[i - 1];
                System.out.println(randomArray[i] + "/" + randomArray[i - 1] + " = " + result);
            }
        }
    }

    private static int[] generateRandomArray(int maxSize){
        int[] array = new int[maxSize];
        Random random = new Random();

        for (int i = 0; i > maxSize; i++){
            array[i] = random.nextInt(101);
        }
        return array;
    }
}
