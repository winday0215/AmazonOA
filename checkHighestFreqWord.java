import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static List<String> findHighestFreqWord(String text, List<String> exclude) {
    
    List<String> ans = new ArrayList<String>();
    if (text == null || text.length() == 0) {
      return ans;
    }
    
    Set<String> eWords = new HashSet<>();
    for (int i = 0; i < exclude.size(); i++) {
      eWords.add(exclude.get(i));
    }
    
    String[] textWords = text.split("[^a-zA-Z]+");
    
    Map<String, Integer> freq = new HashMap<String, Integer>();
    for (int i = 0; i < textWords.length; i++) {
      String cur = textWords[i].toLowerCase(); 
      if (eWords.contains(cur)) {
        continue;
      }
      
      freq.put(cur, freq.getOrDefault(cur, 0) + 1);
    }
    
    int highestFreq = 0;
    for (String key : freq.keySet()) {
      highestFreq = Math.max(highestFreq, freq.get(key));
    }
    
    for (String key : freq.keySet()) {
      if (freq.get(key) == highestFreq) {
        ans.add(key);
      }
    }
    
    return ans;
  }
  
  
    
  public static void main(String[] args) {
    String s = "This method has two variants. The first variant converts all of the characters in this String to lower case using the rules of the given Locale. This is equivalent to calling toLowerCase(Locale.getDefault()).The second variant takes locale as an argument to be used while converting into lower case.";
    
    List<String> e = new ArrayList<>(Arrays.asList("a", "the", "an"));
    
    List<String> ans = findHighestFreqWord(s, e);
    for (String x : ans) {
      System.out.println(x);
    }
  }
}

