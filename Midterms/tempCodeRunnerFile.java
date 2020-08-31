import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.lang.model.util.ElementScanner6;

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
        if (i == 3)
        {
            return (a+b+c) % MOD;
        }
        return compute_ans(b,c,a+b+c,i-1) % MOD;
	}
}