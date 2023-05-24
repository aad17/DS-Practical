package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            ServerInterface server = (ServerInterface) registry.lookup("Server");

            int data = Integer.parseInt(System.console().readLine("Enter data to send to server"));
            int result = server.ProcessData(data);

            System.out.println("Server returned: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
}
