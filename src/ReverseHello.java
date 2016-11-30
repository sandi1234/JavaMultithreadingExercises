
public class ReverseHello extends Thread{
    int count;

    public ReverseHello(int count) {
        this.count = count;
    }

    public ReverseHello() {
        count = 1;
    }

    @Override
    public void run() {
        if (count <= 50) {
            ReverseHello thread = new ReverseHello(count + 1);
            thread.start();
            try {
                //wait for child thread to finish
                thread.join();
                System.out.println("Hello from Thread " + count +" !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
