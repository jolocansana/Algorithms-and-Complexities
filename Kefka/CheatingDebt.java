import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.lang.Integer;

public class CheatingDebt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        String num = br.readLine().trim();
        // build your answer in the StringBuilder to avoid TLE
        StringBuilder sb = new StringBuilder(num);
    
        
    }
}