import java.util.*;

public class AssociationForComputing
{
    public static void main (String[] args)
    {
        AssociationForComputing sorter = new AssociationForComputing();
        Scanner keyin = new Scanner(System.in);

        int N = keyin.nextInt();
        int p = keyin.nextInt();
        int mins[] = new int[N];
        int pt = 0;
        int currSum = 0;
        int result[] = new int[N];
        int k = 0;

        for (int i = 0; i < N; i++)
        {
            mins[i] = keyin.nextInt();
        }

        if (mins[p] < 301)
        {
            result[0] = mins[p];
            mins[p] = -1;
            sorter.sort(mins, 0, N-1);
    
            currSum += result[0];
            pt += currSum;
            k = 1;
            while(k < N && currSum + mins[k] <= 300)
            {
                result[k] = mins[k];
                currSum += mins[k];
                pt += currSum;
                k++; 
            }

        }

        System.out.println(String.format("%d %d", k, pt));
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