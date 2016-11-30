import java.util.Random;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        //to run the max value exercise
        runMaxValue();

        //to run the reverseHello exercise
        runReverseHello();

        //to run SharesCounter exercise
        SharedCounter.startThreads();
    }

    public static void runMaxValue() throws InterruptedException {
        int[] arr = new int[4];
        Random random = new Random();

        System.out.print("Random numbers: ");
        for (int i = 0; i < arr.length; i++) {
            int ranInt = random.nextInt(10 - 0 + 1) + 0;
            System.out.print(ranInt + " ");
            arr[i] = ranInt;
        }
        int sum = MaxValue.max(arr);

        System.out.println("\nMax: " + sum);
    }

    public static void runReverseHello() {
        ReverseHello reverseHello = new ReverseHello();
        reverseHello.start();
    }
}
