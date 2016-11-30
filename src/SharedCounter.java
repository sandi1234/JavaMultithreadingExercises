
public class SharedCounter extends Thread {

    static int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter += 1;
        }
    }

    public static void startThreads() throws InterruptedException {

        for(int i = 0; i < 10; i++) {
            SharedCounter thread = new SharedCounter();
            thread.start();
            //uncomment to join thread (wait for all thread to finish). In this case the count will always be 100
//            thread.join();
        }

        //Uncomment to pasue execution for a given milliseconds. In this case all 10 threads have time to finish their executions and in most cases the final count will be 100

        // test with 100 milliseconds = final count 100
//        Thread.sleep(100);
        //test with 1 milliseconds = final count varies and is not always 100
//        Thread.sleep(1);

        System.out.println(counter);
    }

}
