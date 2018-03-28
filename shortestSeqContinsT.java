import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static int maxLen = Integer.MAX_VALUE;
  public static int[] shortestSeqContinsT(List<String> s, List<String> t) {
    if (s == null || s.size() == 0 || t == null || t.size() == 0) {
      return new int[]{0};
    }
    
    
    Map<String, Integer> tHash = new HashMap<String, Integer>();
    initializeT(t, tHash);
    int[] ans = new int[2];
    Arrays.fill(ans, -1);
    
    Map<String, Integer> sHash = new HashMap<String, Integer>();
    int j = 0;
    for (int i = 0; i < s.size(); i++) {
      while (j < s.size() && !valid(tHash, sHash)) {
        sHash.put(s.get(j), sHash.getOrDefault(s.get(j), 0) + 1);
        j++;
      }
      
      if (valid(tHash, sHash)) {
        if (maxLen > j - i) {
          maxLen = j - i;
          ans[0] = i;
          ans[1] = j - 1;
        }
      }
      
      int val = sHash.get(s.get(i));
      sHash.put(s.get(i), val - 1);
    }
    
    if (ans[0] == - 1 && ans[1] == -1) {
      return new int[]{0};
    }
    
    return ans;
  }
  
  private static void initializeT(List<String> t, Map<String, Integer> tHash) {
    for (String s : t) {
      tHash.put(s, tHash.getOrDefault(s, 0) + 1);
    }
  }
  
  private static boolean valid(Map<String, Integer> tHash, Map<String, Integer> sHash) {
    for (String key : tHash.keySet()) {
      if (!sHash.containsKey(key)) {
        return false;
      }
      
      int vt = tHash.get(key);
      int vs = sHash.get(key);
      if (vt > vs) {
        return false;
      }
    }
    return true;
  }
        
  public static void main(String[] args) {
    List<String> t = new ArrayList<>(Arrays.asList("made","in","china"));
    List<String> s = new ArrayList<>(Arrays.asList("made", "a","b","c","in", "china","made","b","c","d"));
    
    int[] ans = shortestSeqContinsT(s, t);
    System.out.println(ans[0] + ", " + ans[1]);
  }
}



