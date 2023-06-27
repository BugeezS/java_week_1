import java.util.Random;

public class DivisionArrayExample{
    public static void main (String[] args){
        int[] array = generateRandomArray(10); //Generate a random array of size 10
        printArray(array);

        try{
            for (int i = 1; i < array.length ; i++) {
                int result = divide (array[i], array[i - 1]);
                System.out.println(array[i] + "/" + array[i - 1] + "=" + result);
            }
        }catch (ArithmeticException e) {
            System.out.println("Error : Division by zero.");
        }
    }

    //Generate a random array of non-primitive integers
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) ; //Random integer between 0 and 100
        }
        return array;
    }

    //Divide two integers and handle division by zero
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return dividend / divisor;
    }

    //Print the elements of an array
    public static void printArray(int[] array) {
        System.out.println("Array:[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
