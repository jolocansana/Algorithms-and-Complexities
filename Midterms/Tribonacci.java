import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tribonacci
{
	public static final long MOD = 1000000007L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().trim().split(" ");
		long a = Long.parseLong(parts[0]);
		long b = Long.parseLong(parts[1]);
		long c = Long.parseLong(parts[2]);
		long i = Long.parseLong(parts[3]);
		System.out.println(compute_ans(a,b,c,i));
	}

	public static long compute_ans(long a, long b, long c, long i){
        // compute for and return answer here
        
        /*if (i <= 3)
        {
            return (a+b+c) % MOD;
        }
        return compute_ans(b,c,a+b+c,i-1) % MOD;
        */
        long seq[] = {a,b,c};
        int curr = 0;
        while(i > 3)
        {
            long fib = seq[0] % MOD +seq[1] % MOD + seq[2] % MOD;
            if(curr == 3)a
                curr = 0;
            seq[curr] = fib;
            i--;
            curr++;
        }

        return (seq[0]+seq[1]+seq[2]) % MOD;
    }
    
}