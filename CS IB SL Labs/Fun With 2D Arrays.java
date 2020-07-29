import java.lang.*;
import java.util.*;
import java.lang.Math;

/*
* @author Nicole Wong
*/
class FunWith2DArrays {
  /*
   * preCondition : isArrow[i].length == isArrow[k].length for all i, k, 0 < i,j <
   * isArrow.length isArrow.length > 0 && isArrow[0].length > 0
   *
   * postCondition: returns true if the 2D array is a square array (same number of
   * rows and columns) and the 2d array contains zeros in all entries except the
   * first row, first column and the main diagonal
   */
  public boolean isArrowHeadArray(int[][] isArrow) {

    for (int x = 0; x < isArrow.length; x++) {
      for (int y = 0; y < isArrow[x].length; y++) {
        if (x == 0) {
          if (isArrow[x][y] == 0) {
            return false;
          }
        }

        else if (y == 0) {
          if (isArrow[x][y] == 0) {
            return false;
          }
        }

        else if (x == y) {
          if (isArrow[x][y] == 0) {
            return false;
          }
        } else if (isArrow[x][y] != 0) {
          return false;
        }
      }
    }
    return true;
  }

  /*
   * preCondition : gpa[j].length == gpa[k].length for 0 <= j, k < gpa.length
   * gpa.length > 0 && gpa[0].length > 0
   *
   *
   * postcondition : returns true if mgp is as Generalized Permutation Matrix with
   * integer entries that is, returns true iff the following conditions are true
   * 1) All entries in the Matrix are integers since you are being passed an
   * int[][], you do not need to test this condition 2) there is exactly one
   * nonzero entry in each row and each column. The nonzero entry can be any
   * nonzero value (e.g., a positive or negative int) 3) The array is a square
   * array (number of rows == number of columns)
   */
  public boolean isIntegerGeneralizedPermutationArray(int[][] gpa) {
    int countR = 0;
    int countC = 0;
    for (int x = 0; x < gpa.length; x++) // checking rows
    {
      for (int y = 0; y < gpa[x].length; y++) {
        if (gpa[x][y] != 0) {
          countR++;
        }
      }
      if (countR != 1) {
        return false;
      }
      countR = 0;
    }

    int count = 0;
    while (count > gpa[0].length) {
      for (int x = 0; x < gpa[count].length; x++) {
        if (gpa[x][count] != 0) {
          countC++;
        }
      }
      if (countC != 1) {
        return false;
      }
      countC = 0;
      count++;
    }

    return true;
  }

  /*
   * preCondition : ma[i].length == ma[k].length for all i, k, 0 <= i,j <
   * ma.length ma.length > 0 && ma[0].length > 0
   *
   * Do NOT assume the 2d array is a square array That is, ma.length may not be
   * equal to ma[0].length
   *
   * postcondition : returns true if ma is a Monge Matrix A m-by-n matrix is said
   * to be a Monge array if for all i, j, k, p with 0 <= i K k < m and 0 <= j < p
   * < n and ma[i][j] + ma[k][p] <= ma[i][p] + ma[k][j]
   */
  public boolean isMongeArray(int[][] ma) {
    for (int i = 0; i < ma.length - 1; i++) {
      for (int j = 0; j < ma[i].length - 1; j++) {
        int hello = ma[i][j] + ma[i + 1][j + 1];
        int bye = ma[i][j + 1] + ma[i + 1][j];
        if (hello > bye) {
          return false;
        }
      }
    }
    return true;
  }
}