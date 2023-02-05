//how to implement threads?
public class App extends Thread {
    private final String name;

    public App(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for (; ; ) {
                System.out.println(name);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new App("First Thread");
        Thread t2 = new App("Second Thread");
        t1.start();
        t2.start();
        System.out.println("just trying blackbox to be refrences");
    }
}



