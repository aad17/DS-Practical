package CORBA;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl calculator = new CalculatorImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Calculator", calculator);
            System.out.println("Calculator Server is running");

        } catch (RemoteException | MalformedURLException e) {
            System.err.println("Error starting the server "+e.toString());
            e.printStackTrace();
        }

    }
}
