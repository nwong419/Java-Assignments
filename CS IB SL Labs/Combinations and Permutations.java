import java.lang.*;
import java.util.*;
import java.lang.Math;

/**
* @author Nicole Wong
*/

class GeneratingCombinations
{
    public static int factorial(int n)
    {
        int fact = 1;
        int i = 1;
        while(i <= n) {
         fact *= i;
         i++;
      }
      return fact;
    }
    
    public static int gcd(int num1, int num2)
    {
      int a = num1;
      int b = num2;
      int gcd = 0;
      for(int i = 1; i <= a && i <= b; i++)
        {
            if(a%i==0 && b%i==0)
                gcd = i;
        }
      return gcd;
    }
    
    public static int nChoseR(int n, int r)
    {
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int x = r+1; x<=n; x++)
        {
          num.add(x);
        }
        
        ArrayList<Integer> denom = new ArrayList<Integer>();
        for (int x = 1; x<=n-r; x++)
        {
          denom.add(x);
        }
        
        for (int x=0; x<denom.size(); x++)
        {
          for (int y=0; y<num.size(); y++)
          {
            int gcd = gcd(denom.get(x), num.get(y));
            if (gcd > 1)
            {
              denom.set(x, denom.get(x)/gcd);
              num.set(y, num.get(y)/gcd);
            }
          }
        }
        
        int product = 1;
        for (int x=0; x<num.size(); x++)
        {
          product *= num.get(x);
        }
        return product;
    }

    public static int nPermutR(int n, int r)
    {
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int x = (n-r)+1; x<=n; x++)
        {
          num.add(x);
        }
        
        int product = 1;
        for (int x=0; x<num.size(); x++)
        {
          product *= num.get(x);
        }
        return product;
    }

    /*
     * precondition:  1 < n < 10
     *                 r <= n
     *                if r == n, return "1234...n" as only element in array
     *                
     * 
     *   @return all r-combinations of n in increasing lexigraphical order
     */
     
    
    
    public static String[] inLexigraphicalCombinationOrder(int r, int n)
    {
        List<String> combo = new ArrayList<String>();
        int[] temp = new int[r];
        String str ="";
        for (int i=1; i<=r;i++)
        {
          temp[i-1]=i;
        }
        for (int i=0; i<temp.length; i++)
        {
          str+=temp[i];
        }
        combo.add(str);
        for(int i=2; i<= nChoseR(n,r); i++)
        {
          int m = r-1;
          int max_val = n;
          while (m>0 && temp[m] == max_val)
          {
             m -= 1;
             max_val -= 1;
          }
          if (m==0 && temp[m] == max_val) break;
          temp[m] += 1;
          for (int j = m+1; j<r; j++)
          {
            temp[j] = temp[j-1] +1;
          }
          str="";
          for (int x=0; x<temp.length; x++)
          {
            str += temp[x];
          }
          combo.add(str);
        }
        String[] ans = new String[combo.size()];
          for (int i=0; i<combo.size(); i++)
          {
            ans[i] = combo.get(i);
          }
          return ans;
        }
    

    /*
     * precondition:  1 < n < 10
     * 
     *   @return all permutations of n in increasing lexigraphical order
     */
    public static String[] inLexigraphicalPermutationOrder(int n)
    {
        List<String> perms = new ArrayList<String>();
        int[] temp = new int[n+1];
        String str = "";
        for (int i=1; i<=n; i++)
        {
          temp[i] = i;
        }
        for (int j=1; j<temp.length; j++)
        {
          str+=temp[j];
        }
        perms.add(str);
        for(int i=2; i<= factorial(n);i++)
        {
          int m = n-1;
          while (temp[m] > temp[m+1])
          {
            m -= 1;
          }
          int k = n;
          while (temp[m] > temp[k])
          {
            k -= 1;
          }
          int swap = temp[m];
          temp [m] = temp[k];
          temp[k] = swap;
          int p = m+1;
          int q = n;
          while (p<q)
          {
            swap = temp[p];
            temp [p] = temp[q];
            temp[q] = swap;
            p+= 1;
            q -= 1;
          }
          str = "";
          for (int j = 1; j < temp.length; j++)
          {
            str += temp[j];
          }
          perms.add(str);
        }
        String[] ans = new String[perms.size()];
        for (int i=0; i<perms.size();i++)
        {
          ans[i] = perms.get(i);
        }
        return ans;
    }
}