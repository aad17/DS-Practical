
import java.util.Arrays;

public class BerkeleyAlgorithm {

    public static void main(String[] args) {
        // Simulating the clock time for each server
        int[] serverClocks = {10, 7, 12, 8};
        int averageClockTime = calculateAverageClockTime(serverClocks);

        // Adjusting clock time for each server based on the average clock time
        for (int i = 0; i < serverClocks.length; i++) {
            int timeDifference = averageClockTime - serverClocks[i];
            serverClocks[i] += timeDifference;
            System.out.println("Server " + i + " clock time adjusted by " + timeDifference + " seconds");
        }

        System.out.println("Final clock times for servers: " + Arrays.toString(serverClocks));
    }

    private static int calculateAverageClockTime(int[] serverClocks) {
        int totalClockTime = 0;
        for (int clockTime : serverClocks) {
            totalClockTime += clockTime;
        }
        return totalClockTime / serverClocks.length;
    }
}
