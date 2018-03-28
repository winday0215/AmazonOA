class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return ans;
        }
        
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        int j = 0, anchor = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            j = Math.max(j, last[c - 'a']);
            if (i == j) {
                ans.add(j - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
