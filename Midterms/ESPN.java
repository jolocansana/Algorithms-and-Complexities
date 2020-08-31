import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ESPN {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] parts = br.readLine().trim().split(" ");
		int n = Integer.parseInt(parts[0]);
		long kx = Long.parseLong(parts[1]);
		long ky = Long.parseLong(parts[2]);
        long[][] people = new long[n][2];
        long[] distances = new long[n];
		for(int i = 0; i < n; i++) {
			parts = br.readLine().trim().split(" ");
			people[i][0] = Long.parseLong(parts[0]);
            people[i][1] = Long.parseLong(parts[1]);
            distances[i] = Math.abs(kx-people[i][0]) + Math.abs(ky-people[i][1]);
		}
          // you may put preprocessing here
        Arrays.sort(distances);
      
		int q = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < q; i++) {
			long e = Long.parseLong(br.readLine().trim());
          	// solve for ans here
            int ans = -1;
            int start = 0, end = n - 1;  
            while (start <= end) {  
                int mid = (start + end) / 2;  

                // Move to right side if target is  
                // greater.  
                if (distances[mid] <= e) {  
                    start = mid + 1;  
                }  

                // Move left side.  
                else {  
                    ans = mid;  
                    end = mid - 1;  
                }  
            }  

            if (ans == -1)
            {
                ans = n;
            }
            
          	sb.append(ans).append("\n");
		}
		System.out.print(sb);
    }

}