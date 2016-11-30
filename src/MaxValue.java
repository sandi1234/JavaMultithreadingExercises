/**
 * Created by Samson on 28-11-2016.
 */
public class MaxValue extends Thread {

    private int lo, hi;
    private int[] arr;
    private int ans = 0;

    public MaxValue(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = lo; i < hi; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
    }


    /**
     * finds max value
     */
    public static int max(int[] arr) throws InterruptedException {
        int len = arr.length;
        int ans = 0;

        // Create and start 4 threads.
        MaxValue[] ts = new MaxValue[4];
        for (int i = 0; i < 4; i++) {
            ts[i] = new MaxValue(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }

        // Wait for the threads to finish and sum their results.
        for (int i = 0; i < 4; i++) {
            ts[i].join();
            if (ts[i].ans > ans) {
                ans = ts[i].ans;
            }
        }
        return ans;
    }
}
