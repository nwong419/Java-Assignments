import java.lang.*;
import java.util.*;
import java.lang.Math;

/**
* @author Nicole Wong
*/
class StringSimilarity {
  /*
   * postCondition : return a list with list.get(i).length() == 1 for all i, 0 <=
   * i < list.size() All elements of list are contained in String s1 or String s2
   * Duplicate elements may exist in list if s1 or s2 contain duplicate elements
   */
  public static List<String> stringUnion(String s1, String s2) {
    char[] temp = s2.toCharArray();
    List<String> list2 = new ArrayList<String>();
    for (char text : temp) {
      String use = Character.toString(text);
      list2.add(use);
    }

    List<String> yay = new ArrayList<String>();
    for (int x = 0; x < s1.length(); x++) {
      String s = s1.substring(x, x + 1);
      int countmax = Math.max(count(s, s1), count(s, s2));
      if (!yay.contains(s)) {
        if (count(s, s2) > 0) {
          list2.removeAll(Collections.singleton(s));
        }

        while (countmax > 0) {
          yay.add(s);
          countmax--;
        }
      }
    }
    for (int x = 0; x < list2.size(); x++) {
      yay.add(list2.get(x));
    }
    return yay;
  }

  /*
   * postCondition : return a list with list.get(i).length() == 1 for all i, 0 <=
   * i < list.size() All elements of list are contained in both String s1 and
   * String s2 Duplicate elements may exist in list if both s1 and s2 contain
   * duplicate elements
   */
  public static List<String> stringIntersection(String s1, String s2) {
    List<String> ans = new ArrayList<String>();

    for (int x = 0; x < s1.length(); x++) {
      String s = s1.substring(x, x + 1);
      if (count(s, s2) > 0) {
        int countmin = Math.min(count(s, s1), count(s, s2));
        if (!ans.contains(s)) {
          while (countmin > 0) {
            ans.add(s);
            countmin--;
          }
        }
      }

    }
    return ans;
  }

  public static double getJaccardIndex(String s1, String s2) {
    double intersection = Math.abs(stringIntersection(s1, s2).size());
    double union = Math.abs(stringUnion(s1, s2).size());
    double ans = intersection / union;
    if (union == intersection)
      return 1.0;
    return ans;
  }

  public static int count(String s, String s1) {
    int ans = 0;
    char[] ch = s1.toCharArray();
    for (char c : ch) {
      String use = Character.toString(c);
      if (use.equals(s)) {
        ans++;
      }
    }
    return ans;
  }
}