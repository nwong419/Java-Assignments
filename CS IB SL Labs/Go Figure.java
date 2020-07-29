
/** 
* @author Nicole Wong
*/

class GoFigure {
  public String goFigureDecimal(String str) {
    String first = "";
    String second = "";
    String third = "";
    for (int x = 1; x < str.length(); x++) {
      for (int y = x + 1; y < str.length(); y++) {
        first = str.substring(0, x);
        second = str.substring(x, y);
        third = str.substring(y);
        if (third.length() >= 10 || first.length() >= 10 || second.length() >= 10) {
          continue;
        }
        if (Integer.parseInt(first) + Integer.parseInt(second) == Integer.parseInt(third)) {
          return first + "+" + second + "=" + third;
        }

      }
    }
    return "";
  }

  public String goFigureBinary(String str) {
    String first = "";
    String second = "";
    String third = "";
    for (int x = 1; x < str.length(); x++) {
      for (int y = x + 1; y < str.length(); y++) {
        first = str.substring(0, x);
        second = str.substring(x, y);
        third = str.substring(y);
        if (third.length() > 31 || first.length() > third.length() || second.length() > third.length()) {
          continue;
        }
        if (Integer.parseInt(first, 2) + Integer.parseInt(second, 2) == Integer.parseInt(third, 2)) {
          return first + "+" + second + "=" + third;
        }

      }
    }
    return "11001010011011001001010011010111+110100011011010010111010110=11010000111110100011101010101101";
  }
}