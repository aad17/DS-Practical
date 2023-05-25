import java.util.*;

public class RingAlgorithm{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter number of nodes: ");
            int n = sc.nextInt();
            int[] nodeIds = new int[n];

            for(int i = 0; i < n; i++){
                System.out.println("Enter Id of Node " + (i+1) + " : ");
                nodeIds[i] = sc.nextInt();
            }

            int coordinator = -1;
            int maxId = -1;
            
            for(int i = 0; i < n; i++){
                int successor = (i + 1) % n;
                System.out.println("Node " + nodeIds[i] + " sends an election message to node " + nodeIds[successor]);

                if(nodeIds[i] > maxId){
                    maxId = nodeIds[i];
                }
            }

            // Message passing to let know all the nodes who is the coordinator
            while(coordinator == -1){
                for(int i = 0; i < n; i++){
                    int successor = (i + 1) % n;
                    int predecessor = (i - 1 + n) % n;
                    if(nodeIds[predecessor] == maxId) {
                        coordinator = nodeIds[predecessor];
                    }
                    System.out.println("Node " + nodeIds[i] + " forwards message from " + nodeIds[predecessor] + " to " + nodeIds[successor]);
                }
            }
            System.out.println("Coordinator is " + coordinator);
        }
    }
}