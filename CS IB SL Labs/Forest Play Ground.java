import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.lang.Math;
/**
 * @author Nicole Wong
 */
class ForestPlayGround 
{
    String[] myTree;

    /*
     *   PreConditions
     *        tree is a valid represntation fo a binary tree
     *        tree != null
     *        tree.size() >= 0
     */
    public ForestPlayGround(String[] tree)
    {
        myTree = tree;
    }

    /*
     *    return the number of non null nodes in myTree
     */
    public int getNumNodes()
    {
        int numNodes = 0;
        for (int x=0; x<myTree.length; x++)
        {
          if (myTree[x] != null)
          {
            numNodes++;
          }
        }
        return numNodes;
    }

    /*
     *    A leaf is a node in the tree in which both children have 0 children.
     *    An empty tree contains NO leafs
     */
     

    public int getNumLeafs()
    {
      
        int numLeafs = 0;
        for (int x = 0; x<myTree.length; x++)
        {
          if(myTree[x] != null)
          {
            if (getRightChild(x) == null && getLeftChild(x) == null)
           {
              numLeafs++;
           }
          }
          
        }
        return numLeafs;
    }


    /*
     *    Precondition:   0 <= p < myTree.length
     *
     *    returns:
     *        the right child of myTree[p]
     *        null if myTree[p] does not have a right child
     */
    public String getRightChild(int p)
    {
        if (2*p+2 > myTree.length-1)
        {
        return null;
        }
        else {
        return myTree[2*p+2];
        }
    }

    /*
     *    Precondition:   0 <= p < myTree.length
     *
     *    returns:
     *        the left child of myTree[p]
     *        null if myTree[p] does not have a left child
     */
    public String getLeftChild(int p)
    {

        if (2*p+1 > myTree.length-1)
        {
        return null;
        }
        else {
        return myTree[2*p+1];
        }
    }

    /*
     *    Precondition:   0 <= p < myTree.length
     *                    myTree[p] != null
     *
     *    returns:
     *        the parent of myTree[p]
     *        null if myTree[p] does not have a parent
     */
    public String getParent(int p)
    {
        if (p == 0)
        {
          return null;
        }
        return myTree[(int)Math.floor((p-1)/2)];
    }

    /*
     *    Precondition:   0 <= p < myTree.length
     *                    myTree[p] != null
     *
     *    returns:
     *        the List of all ancestors (parent and their parent ans so on) of myTree[p]
     *        an empty List if myTree[p] does not have a parent
     */
    public List<String> getAncestors(int p)
    {
        List<String> ans = new ArrayList<String>();
        int count = p;
        while (count!=0)
        {
          ans.add(getParent(count));
          count = (int)Math.floor((count-1)/2);
          //count = Integer.parseInt(getParent(count));
        }

        return ans;
    }

    /*
     * Preconditions:
     *    myTree[p] != null
     *    0 <= p < myTree.length
     */
    public List<String> getDescendants(int p)
    {
      
        List<String> ans = new ArrayList<String>();
        for (int x =0; x<myTree.length; x++)
        {
          if(myTree[x] != null)
          {
          List<String> tempAns = getAncestors(x);
          if (tempAns.contains(myTree[p]))
          {
            ans.add(myTree[x]);
          }
          }
        }
        return ans;
    }

    /*
     *    In a complete binary tree every level, except possibly the last, is completely filled,
     *    and all nodes in the last level are as far left as possible.
     *    
     *    This implies that the end of the array may contain multiple nulls
     *                               and the array/tree may still be complete
     */
    public boolean isComplete()
    {
      int count = getNumNodes();
     // List<Integer> temp = new ArrayList<Integer>
      for (int x =0; x<count; x++)
      {
        if (myTree[x] == null)
        {
          return false;
        }
      }
      return true;
    }

    /*
     *    A full binary tree is a tree in which every node in the tree has either 0 or 2 children.
     */
    public boolean isFull()
    {
        for (int x = 0; x<myTree.length; x++)
        {
          if (getLeftChild(x) == null && getRightChild(x) != null)
          {
            return false;
          }
          if (getLeftChild(x) != null && getRightChild(x) == null)
          {
            return false;
          }
        }
        return true;
    }
}