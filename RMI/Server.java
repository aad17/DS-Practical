package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements ServerInterface{
    public static void main(String[] args) {
        try {
            Server server = new Server();
            ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server", stub);
            System.out.println("Server Started");

        } catch (Exception e) {
            System.err.println("Server exeption: " + e.toString());
        }
    }

    @Override
    public int ProcessData(int data) throws RemoteException {
        int result = data * 2;
        return result;
    }
}
