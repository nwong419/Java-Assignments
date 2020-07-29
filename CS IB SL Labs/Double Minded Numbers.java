import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author Nicole Wong
 */
 class DoubleMindedNumbers
{
    public static boolean isDoubleMindedNumber(int num)
    {
    Set<Integer> set = new HashSet<Integer>();
    String temp = Integer.toString(num);
    for (int i = 0; i < temp.length(); i++)
    {
      set.add(temp.charAt(i) - '0');
    }
    if (temp.length() != set.size() + 1)
    {
      return false;
    }
    return true;
    }

    public static int distanceToNextDoubleMindedNumber(int num)
    {
      int next = num;
      if (isDoubleMindedNumber(num))
      {
        return 0;
      }
      while (!isDoubleMindedNumber(next))
      {
        next++;
      }
      return next - num;
    }

    /*   
     *    include min and max
     */
    public static int[] getDoubleMindedBetween(int min, int max)
    {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      for (int x=min; x<=max; x++)
      {
        if (isDoubleMindedNumber(x))
        {
          temp.add(x);
        }
      }
      int[] array = new int[temp.size()];
      for (int x=0; x<temp.size();x++)
      {
        array[x] = temp.get(x);
      }
      return array;
    }
}