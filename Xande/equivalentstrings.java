import java.util.*;

public class equivalentstrings
{
    public static void main (String[] args)
    {
        equivalentstrings es = new equivalentstrings();
        Scanner keyin = new Scanner(System.in);
        String sOne = keyin.nextLine();
        String sTwo = keyin.nextLine();

        if (sOne.length() != sTwo.length())
        {
            System.out.println("NO");
        }
        else
        {
            if (sOne.length() <= 1)
            {
                if (sOne.equals(sTwo))
                {
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }
            else
            {
                String A1 = sOne.substring(0, sOne.length()/2);
                String A2 = sOne.substring(sOne.length()/2, sOne.length());
                String B1 = sTwo.substring(0, sTwo.length()/2);
                String B2 = sTwo.substring(sTwo.length()/2, sTwo.length());
                
                String temp;

                if (A1.compareTo(A2) > 0)
                {
                    temp = A1;
                    A1 = A2;
                    A2 = temp;
                }

                if (B1.compareTo(B2) > 0)
                {
                    temp = B1;
                    B1 = B2;
                    B2 = temp;
                }
                es.checkEquivalences(A1, A2, B1, B2);

                if(es.notEquivalent == 0)
                    System.out.println("YES");
                 else
                    System.out.println("NO");
            }
        }

    }

    public int notEquivalent;

    public void checkEquivalences (String A1, String A2, String B1, String B2)
    {
        String temp = new String();
        /*
        if ((A1.equals(B2) && A2.equals(B2)) || (A1.equals(B2) && B1.equals(A2)))
        {
            if (A1.length() != 1)
            {
                checkEquivalences(A1.substring(0, A1.length()/2-1), A1.substring(A1.length()/2, A1.length()-1), B1.substring(0, B1.length()/2-1), B1.substring(B1.length()/2, B1.length()-1));
                checkEquivalences(A2.substring(0, A2.length()/2-1), A2.substring(A2.length()/2, A2.length()-1), B2.substring(0, B2.length()/2-1), B2.substring(B2.length()/2, B2.length()-1));    
            }
        }
        else
            notEquivalent++;
            */

        if (A1.length() == 1)
        {
            if(!(A1.equals(B1) || A1.equals(B2)))
            {
                notEquivalent++;
            }
        }

        if (A2.length() == 1)
        {
            if(!(A2.equals(B2) || A2.equals(B1)))
            {
                notEquivalent++;
            }
        }

        if (A1.length() > 1 || A2.length() > 1)
        {
            if (A1.compareTo(A2) < 0)
            {
                temp = A1;
                A1 = A2;
                A2 = temp;
            }
    
            if (B1.compareTo(B2) < 0)
            {
                temp = B1;
                B1 = B2;
                B2 = temp;
            }
            
            checkEquivalences(A1.substring(0, A1.length()/2), A1.substring(A1.length()/2, A1.length()), B1.substring(0, B1.length()/2), B1.substring(B1.length()/2, B1.length()));
            checkEquivalences(A2.substring(0, A2.length()/2), A2.substring(A2.length()/2, A2.length()), B2.substring(0, B2.length()/2), B2.substring(B2.length()/2, B2.length()));    
        }
    }


}