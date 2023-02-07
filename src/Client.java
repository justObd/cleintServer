import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static Connection connection;
    public static void main(String[] args) throws IOException, SQLException {
        String line;
        String ClientInput;
            
        try {
            Socket client = new Socket("localhost", 2000); // it will connect the client with the server
            
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            Scanner sc = new Scanner(System.in);                                 
            Scanner receiver = new Scanner(in);
            PrintWriter writer = new PrintWriter(out, true);
            testDatabaseConnection();//test the database connetion
            System.out.println("first part completed ");//for debug
            
            ArrayList<String> inp = new ArrayList<String>();
            inp.add("Enter username:");
            inp.add("Enter Password:");
            inp.add("choose: ");
            inp.add("Which room do you want to update?");      
            inp.add("Enter check in date DD/MM: ");            
            inp.add("Update visitor name");                    
            inp.add("Enter check out date DD/MM: ");
            inp.add("ENTER ROOM NO: ");
            System.out.println("second part completed");//for debug
            System.out.println("  "); //just for practice gitHub

            
            while (true) {
                line = receiver.nextLine();
                System.out.println(line);
                if (inp.contains(line)) {                              
                    ClientInput = sc.nextLine();                       
                    writer.println(ClientInput);                        
                }
            }

        } catch (ConnectException e) { // if the server was offline it this exception will handel it
            System.out.println("Server is offline");
            System.out.println("eceeption occured o");
        }
    }
    private static void closeDatabaseConnection() throws SQLException  {
        connection.close();  
   
       }
   
       
       private static void testDatabaseConnection() throws SQLException{
          connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/client","root","123");
          System.out.println("Database connection is valid : "+connection.isValid(5));
   
       }
}
