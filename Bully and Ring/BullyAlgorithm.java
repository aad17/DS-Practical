import java.util.Scanner;

public class BullyAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int[] processes = new int[n];

        System.out.println("Enter the process IDs:");
        for (int i = 0; i < n; i++) {
            processes[i] = sc.nextInt();
        }

        System.out.print("Enter the process ID initiating the election: ");
        int initiatingProcess = sc.nextInt();

        int initiatingProcessIdx = findinitiatingProcessIdx(processes, initiatingProcess);
        int coordinatorIdx = -1;
        int coordinator = initiateElection(processes, initiatingProcess, initiatingProcessIdx, coordinatorIdx);

        System.out.println("Election initiated by process " + initiatingProcess);
        System.out.println("Coordinator process is " + coordinator);

        sc.close();
    }

    public static int findinitiatingProcessIdx(int[] processes, int initiatingProcess){
        int initiatingProcessIdx = -1;
        for(int i = 0; i < processes.length; i++){
            if(processes[i] == initiatingProcess){
                initiatingProcessIdx = i;
                break;
            }
        }
        return initiatingProcessIdx;
    }

    public static int initiateElection(int[] processes, int initiatingProcess, int initiatingProcessIdx, int coordinatorIdx) {
        int coordinator = initiatingProcess;
        coordinatorIdx = initiatingProcessIdx;
        for (int i = initiatingProcessIdx + 1; i < processes.length; i++) {
            System.out.println("Process " + coordinator + " sends message to process " + processes[i] + " with index as: " + i);
            if (processes[i] > coordinator) {
                System.out.println("Process " + processes[i] + " with index as: " + i + " responded to process " + coordinator);
                coordinator = processes[i];
                coordinatorIdx = i;
            }
        }

        for (int i = 0; i < initiatingProcessIdx; i++) {
            System.out.println("Process " + coordinator + " sends message to process " + processes[i] + " with index as: " + i);
            if(processes[i] > coordinator){
                System.out.println("Process " + processes[i] + " with index as: " + i + " responded to process " + coordinator);
                coordinator = processes[i];
                coordinatorIdx = i;
            }
        }

        return coordinator;
    }

}