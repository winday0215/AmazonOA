import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static List<String> find(String s, int k) {
    
    if (s == null || s.length() == 0 || k == 0) {
      return new ArrayList<String>();
    }
    
    
    int[] hash = new int[26];
    for (int i = 0; i < k - 1; i++) {
      hash[s.charAt(i) - 'a']++;
    }
    
    Set<String> set = new LinkedHashSet<>();
    for (int i = k - 1; i < s.length(); i++) {
      char c = s.charAt(i);
      hash[c - 'a']++;
      
      if (valid(hash)) {
        set.add(s.substring(i - k + 1, i + 1));
      }
      
      hash[s.charAt(i - k + 1) - 'a']--;
    }
    
    return new ArrayList<String>(set);
  }
  
  private static boolean valid(int[] hash) {
    
    for (int i = 0; i < hash.length; i++) {
      if (hash[i] > 1) {
        return false;
      }
      
    }
    return true;
  }
        
    
  public static void main(String[] args) {
    String s = "awaglknagawunagwkwagl";
    List<String> ans = find(s, 4);
    
    for (String x : ans) {
      System.out.println(x);
    }
  }
}

