package CORBA;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/Calculator");
            try (Scanner scanner = new Scanner(System.in)) {
                while (true){
                    System.out.println("Enter operation (add/subtract/multiply/divide)");
                    String operation = scanner.nextLine();
                    System.out.println("Enter first number");
                    double a = scanner.nextDouble();
                    System.out.println("Enter second number");
                    double b = scanner.nextDouble();
                    double result;

                    switch (operation) {
                        case "add":
                            result = calculator.add(a, b);
                            System.out.println("Result: " + result);
                            break;
                        case "subtract":
                            result = calculator.subtract(a, b);
                            System.out.println("Result: " + result);
                            break;
                        case "multiply":
                            result = calculator.multiply(a, b);
                            System.out.println("Result: " + result);
                            break;
                        case "divide":
                            result = calculator.divide(a, b);
                            System.out.println("Result: " + result);
                            break;
                        default:
                            System.out.println("Invalid operation");
                            break;
                    }
                    scanner.nextLine();
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
