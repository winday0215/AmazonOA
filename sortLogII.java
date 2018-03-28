import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static int compareWord(String s1, String s2) {
    int i = 0, j = 0;
    while (i < s1.length() && j < s2.length()) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(j);
      
      boolean isDigC1 = Character.isDigit(c1);
      boolean isDigC2 = Character.isDigit(c2);
      
      if ((isDigC1 && isDigC2) ||(!isDigC1 && !isDigC2)) {
        if (c1 < c2) return -1;
        else if (c1 > c2) return 1;
      } else if (isDigC1) {
        return 1;
      } else if (isDigC2) {
        return -1;
      }
      
      i++;
      j++;
    }
    return 0;
  }
  
  static class WordComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      String[] a = s1.split("\\s+");
      String[] b = s2.split("\\s+");
      
      int i = 1, j = 1;
      while (i < a.length && j < b.length) {
        if (compareWord(a[i], b[j]) < 0) {
          return -1;
        } else if (compareWord(a[i], b[j]) > 0) {
          return 1;
        }
        i++;
        j++;
      }
      
      //tie, compare identifier a[0] and b[0]
      if (i == a.length && j == b.length) {
        if (compareWord(a[0], b[0]) < 0) {
          return -1;
        } else if (compareWord(a[0], b[0]) > 0) {
          return 1;
        }
        return 0;
      }
      
      //a is shorter than b
      if (i == a.length) {
        return -1;
      }
      
      //a is longer than b
      if (j == b.length) {
        return 1;
      }
      
      return 0;
    }
  }
  
  public static List<String> sortLog(List<String> logs, int logSize) {
    List<String> ans = new ArrayList<>(logSize);
    if (logs == null || logs.size() == 0) {
      return ans;
    }
    
    List<String> words = new ArrayList<>();
    List<String> nums = new ArrayList<>();
    
    for (String log : logs) {
      int index = log.indexOf(" "); //index of first white space
      if (Character.isDigit(log.charAt(index + 1))) {
        nums.add(log);
      } else {
        words.add(log);
      }
    }
    
    Collections.sort(words, new WordComparator());
    
    ans.addAll(words);
    ans.addAll(nums);
    return ans;
  }
        
  public static void main(String[] args) {
    List<String> logs = new ArrayList<>();
    //logs.add("a1 9 2 3 1");
    logs.add("1g act car zoo");
    //logs.add("zo4 4 7");
    //logs.add("ab1 off KEY dog");
    logs.add("a8 1ct car zoo");
    
    List<String> sorted = sortLog(logs, 5);
    for (String s : sorted) {
      System.out.println(s);
    }
  }
}

