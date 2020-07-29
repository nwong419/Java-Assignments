import java.lang.*;
import java.util.*;
import java.lang.Math;

/**
 * @author Nicole Wong
 */
class HuffmanCodeWithArray {
  private static String[] letterTree = new String[69];

  public HuffmanCodeWithArray(String[] myTree) {
    letterTree = myTree;
  }

  /*
   * remember: 0 goes left (lousy .... 1 goes right :) a space in message
   * correspnds to a space in the return value
   * 
   * @return
   */

  public String getHuffmanMessage(String message) {
    String ans = "";
    int position = 0;
    // int length = 0;
    for (int x = 0; x < message.length(); x++) {
      int check = (int) (Integer.parseInt(message.substring(x, x + 1)));
      if (check == 0) {
        position = 2 * position + 1;
      }
      if (check == 1) {
        position = 2 * position + 2;
      }
      if (letterTree[position + 1] != null) {
        ans += letterTree[position + 1];
        position = 0;
      }
    }

    return ans;
  }
}