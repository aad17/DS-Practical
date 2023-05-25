// import java.util.Scanner;
import java.util.*;

class TokenRing {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            System.out.println("Enter number of nodes: ");
            int n = scn.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

            int token = 0, reply = 1;
            
            // while loop will start
            while (reply == 1) {
                System.out.println("Enter sender: ");
                int s = scn.nextInt();
                System.out.println("Enter data: ");
                int d = scn.nextInt();
                System.out.println("Enter receiver: ");
                int r = scn.nextInt();

                for (int i = token, j = token; (i % n) != s; i++, j = (j + 1) % n) {
                    System.out.print(" " + j + " -> ");
                }
                
                System.out.println(" " + s);
                System.out.println(" Sender " + s + " sending data " + d + " to reciever " + r);

                for (int i = (s + 1) % n; i != r; i = (i + 1) % n) {
                    System.out.println(" data " + d + " is forwarded by " + i);
                }
                
                System.out.println(" Receiver " + r + " received data " + d);

                token = s; //Token is passed to sender
                
                System.out.println("Do you want to send again? Enter 1 for Yes and 0 for No: ");
                reply = scn.nextInt();
                if(reply != 1 && reply != 0){
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }
    }
}