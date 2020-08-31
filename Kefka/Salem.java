import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Salem {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = br.readLine().trim().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int f = Integer.parseInt(parts[1]);
		int k = Integer.parseInt(parts[2]);
		int[] vamps = new int[n];
		for(int i = 0; i < n; i++) {
			vamps[i] = Integer.parseInt(br.readLine().trim());
		}

		System.out.println(solve(n,f,k,vamps));
	}
  
  	public static String solve(int n, int f, int k, int[] vamps) {
		// solve answer here
		sort (vamps, 0, n-1);

		for (int i = 0; i < k; i++)
			f -= vamps[i];
		
		if (f >= 0)
			return "YES";
		else
			return "NO";
      	
	}
	
	public static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    public static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        
        }
    } 
}