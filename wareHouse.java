import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static int distance(List<Integer> A) {
    return A.get(0) * A.get(0) + A.get(1) * A.get(1);
  }
  
  
  public static List<List<Integer>> wareHouse(List<List<Integer>> pos, int N, int M) {
    List<List<Integer>> res = new ArrayList<>();
    
    //max heap
    PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(M, (a, b) -> distance(b) - distance(a));
    
    for (List<Integer> p : pos) {
      pq.offer(p);
      if (pq.size() > M) {
        pq.poll();
      }
    }
    
    while (!pq.isEmpty()) {
      res.add(pq.poll());
    }
    
    Collections.reverse(res);
    return res;
  }
    
    
  public static void main(String[] args) {
    List<List<Integer>> pos = new ArrayList<>();
    
    pos.add(new ArrayList<Integer>(Arrays.asList(1, 9)));
    pos.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
        
    pos.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
    pos.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
    
    List<List<Integer>> ans = wareHouse(pos, 4, 3);
    
    for (List<Integer> x : ans) {
      System.out.println(x.get(0) + ", " + x.get(1));
    }
  }
}

