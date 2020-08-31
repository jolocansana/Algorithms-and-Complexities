import java.util.*;

public class equivalentstrings_wrong
{
    public static void main (String[] args)
    {
        int MAX = 200000;
        equivalentstrings_wrong es = new equivalentstrings_wrong();
        Scanner keyin = new Scanner(System.in);
        String sOne = keyin.nextLine();
        String sTwo = keyin.nextLine();

        if (sOne.length() != sTwo.length() || sOne.length() == 0)
            System.out.println("NO");
        else
        {
            if (sOne.length() % 2 == 1)
            {
                if (sOne.equals(sTwo))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            else
            {
                char[] cOne1 = new char[MAX];
                char[] cOne2 = new char[MAX];
                char[] cTwo1 = new char[MAX];
                char[] cTwo2 = new char[MAX];

                sOne.getChars(0, sOne.length()/2, cOne1, 0);
                sOne.getChars(sOne.length()/2, sOne.length(), cOne2, 0);
                sTwo.getChars(0, sTwo.length()/2, cTwo1, 0);
                sTwo.getChars(sTwo.length()/2, sTwo.length(), cTwo2, 0);

                es.sort (cOne1, 0, sOne.length()/2-1);
                es.sort (cOne2, 0, sOne.length()/2-1);
                es.sort (cTwo1, 0, sTwo.length()/2-1);
                es.sort (cTwo2, 0, sTwo.length()/2-1);

                String sOne1 = new String(cOne1);
                String sOne2 = new String(cOne2);
                String sTwo1 = new String(cTwo1);
                String sTwo2 = new String(cTwo2);

                if ((sOne1.equals(sTwo1) && sOne2.equals(sTwo2)) || (sOne1.equals(sTwo2) && sTwo1.equals(sOne2)))
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }
        }
    }

    void merge(char arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        char L[] = new char [n1]; 
        char R[] = new char [n2]; 
  
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
    void sort(char arr[], int l, int r) 
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