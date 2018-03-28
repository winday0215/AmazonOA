import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  static class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
      left = right = null;
    }
  }
  
  public static TreeNode createBST(int[] input){
    //
    TreeNode root = null;
    for (int x: input){
      root = insert(root, x);
    }
    return root;
    
  }
  
  private static TreeNode insert(TreeNode root, int x){
    if(root==null) return new TreeNode(x);
    if(root.val < i){
      root.right = insert(root.right, i);
    }else{
      root.left = insert(root.left, i);
    }
    
    return root;
  }
  
  
  public static TreeNode LCABST(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || p == root || q == root) return root;

    
    if(root.val > p.val && root.val > q.val) {
      return LCABST(root.left, p, q);
    } else if(root.val < p.val && root.val < q.val) {
      return LCABST(root.right, p, q);
    } else {
      return root;
    }
  }
  
  /**
   * return distance between p and q
   * p, q may not exit in the tree
   * @param lca
   * @param p
   * @param q
   * @return
   */
  public static int findDistance(TreeNode root,TreeNode p, TreeNode q){
    if(root==null || p==null || q==null) return -1;
    //p or q not exist
    int dis1 = getDistanceFromRoot(root, p);
    int dis2 = getDistanceFromRoot(root, q);
    if (dis1==-1 ||dis2==-1) return -1;
    else{
      TreeNode lca = LCABST(root, p, q);
      int dis3 = getDistanceFromRoot(root, lca);
      return dis1+dis2-2*dis3;
      
    }
    
  }
  
  public static int getDistanceFromRoot(TreeNode root, TreeNode n){
    if (root==null) return -1;
    if (root.val == n.val) return 0;
    
    int dis = -1;
    if (root.val>n.val) {
      dis =  getDistanceFromRoot(root.left, n);
    }
    else if(root.val<n.val){
      dis =  getDistanceFromRoot(root.right, n);
    }

    if (dis != -1) {
      dis += 1;
    }
    
    return dis;
  }
    
    
  public static void main(String[] args) {
    int[] array = {6, 3, 2, 1, 8, 7, 9};
    
    TreeNode root = createBST(array);
    
    int dis = findDistance(root, new TreeNode(1), new TreeNode(7));
    
    System.out.println(dis);
  }
}

