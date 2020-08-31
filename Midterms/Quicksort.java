import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Quicksort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine().trim());
		System.out.println(compute_ans(t, 0, 20000000000000000l));
	}

	public static long compute_ans(long t, long l, long r) {
        // compute for and return answer here
        long mid = (l+r)/2;
        double res_time = getTime(mid);

        if (t > res_time)
        {
            if (getTime(mid+1) > t)
            {
                return mid;
            }
            return compute_ans(t, mid, r);
        }
        else
        {
            return compute_ans(t, l, mid);
        }
    }

    public static double logb( double a, double b )
    {
        return Math.log(a) / Math.log(b);
    }

    public static double getTime(long n)
    {
        return (n*logb(n, 2))/100000000;
    }
}