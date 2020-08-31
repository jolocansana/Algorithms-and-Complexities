import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SalemsRoad
{
    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] parts = br.readLine().trim().split(" ");
    long L = Long.parseLong(parts[0]);
    int n = Integer.parseInt(parts[1]);
    long[][] coverage = new long[n][2];
    for(int i = 0; i < n; i++){
        parts = br.readLine().trim().split(" ");
        for(int j = 0; j < 2; j++){
            coverage[i][j] = Long.parseLong(parts[j]);
        }
    }
    // Sort the 2d list first by x first, then by Y
    

    // Perform traversal
    // 1. Check if the first x == 1. If not, fail case

    // 2. If x == 1 exists, then get the greatest Y at the set of x

    // 3. Using that Y, find the next that is the greater but is less than or equal to Y+1

    // 4. Perform 2 again until: (1) End of set has been reach :: fail case (2) The max is has been reached.

    // 5. If fail case, return '... doomed', else print NumOfPeople-NumOfIterationsPerformed
    }
}