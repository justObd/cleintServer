package host.app;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class HostApp {

    
    public static void main(String[] args) throws FileNotFoundException {
     //PrintWriter write = new PrintWriter("output"); 
     File f = new File("hostinfo.txt");
     PrintWriter out = new PrintWriter(f);   
     
     Scanner in = new Scanner (System.in);
     
     
        out.println("192.168.100.1 Host1");
        out.println("192.168.102.2 Host2");
        out.flush();
       // System.out.println(read.nextLine());
       
        
        
        
        while (true) {
            System.out.println("User can choose from the Application Services.\n\n");
            System.out.println("1 = Add host\n2 = Get Ip via Host name\n3 = Get Host name via Ip\n4 = List all info\n5 = Exit");
            String choice = "0";

            choice = in.nextLine();

            switch (choice) {
                case "1":

                    System.out.println("Enter Host Name and Ip : ");
                    String x = in.nextLine();
                    if (add(x, out)) {
                        System.out.println("Added is successful");
                    } else {
                        System.out.println("Addition Failed");
                    }
                    break;

                case "2":
                    System.out.println("Enter Host name : ");
                    String y = in.nextLine();
                    String Ipget = getip(y,f);
                    if(Ipget.equalsIgnoreCase("Error 404")){
                        System.out.println("Sorry Host name not found");
                    }else{
                        System.out.println(Ipget);
                    }
                    break;
                    
                case "3" : 
                    System.out.println("Enter ip adress : ");
                    String z = in.nextLine();
                    String Hostget = getHostname(z,f);
                    if(Hostget.equalsIgnoreCase("Error 404")){
                        System.out.println("Sorry Ip adress not found");
                    }else{
                        System.out.println(Hostget);
                    }
                    break;
                    
                case "4" :
                    ArrayList<String> list = list(f);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    

                case "5":
                    exit();
            }
        }

    }

    public static boolean add(String Host, PrintWriter w) {
        boolean stat;

        w.println(Host);

        stat = w.checkError();

        return stat;
    }

    public static String getip(String Host, File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            String[] Token = line.split(" ");

            if (Token[1].equalsIgnoreCase(Host)) {
                return Token[0];
            }
        }
        return "Error 404";
    }

    public static String getHostname(String Ip,File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            String[] Token = line.split(" ");

            if (Token[0].equalsIgnoreCase(Ip)) {
                return Token[1];
            }
        }
        return "Error 404";
    }

    public static ArrayList list(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        ArrayList<String> list = null;
        
        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            list.add(line);
            System.out.println(line);
        }
        return list;
        
    }

    public static void exit(){
       System.exit(0);
    }
}
