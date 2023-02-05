import java.util.ArrayList;
import java.util.Scanner;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("hi my name is abdullah abdulrahim justaniah and i am senior in king abdulaziz university");
        System.out.println("hi this is just practicing to pull and push project to this repositry");
    Scanner sc = new Scanner (System.in);
    System.out.println("enter your name");
    String name = sc.nextLine();
    System.out.println("hello "+name);
        //this code is not neded in the project
ArrayList a =new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            extracted(a, i);
        }
        
    }

    private static boolean extracted(ArrayList a, int i) {
        return a.add(i);
    }
}
