import java.util.*;

public class DragonOfLoowater
{
    public static void main (String[] args)
    {
        int MAX = 20000;
        boolean cont = true;
        DragonOfLoowater s = new DragonOfLoowater();
        Scanner keyin = new Scanner (System.in);

        do 
        {
            int n = keyin.nextInt();
            int m = keyin.nextInt();
            if (n == 0 && m == 0)
            {
                cont = false;
            } 
            else
            {
                int ncm[] = new int[MAX];
                int mcm[] = new int[MAX];
        
                for (int i = 0; i < n; i++)
                {
                    ncm[i] = keyin.nextInt();
                }
        
                for (int i = 0; i < m; i++)
                {
                    mcm[i] = keyin.nextInt();
                }

                s.sort(ncm, 0, n-1);
                s.sort(mcm, 0, m-1);
                
                int np = 0;
                int mp = 0;
                int coins = 0;

                while (mp < m && np < n)
                {
                    if (mcm[mp] >= ncm[np])
                    {
                        coins += mcm[mp];
                        mp++;
                        np++;
                    }
                    else   
                    {
                        mp++;
                    }
                }

                if (np < n || n > m)
                {
                    System.out.println("Loowater is doomed!");
                }
                else
                {
                    System.out.println(coins);
                }
            }
        } while (cont);

    }

    void merge(int arr[], int l, int m, int r) 
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
    void sort(int arr[], int l, int r) 
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