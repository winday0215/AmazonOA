public class Solution {
    /**
     * @param ListA: The relation between ListB's books
     * @param ListB: The relation between ListA's books
     * @return: The answer
     */
    public List<String> maximumAssociationSet(String[] listA, String[] listB) {
        // Write your code here
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        Map<Integer, String> name = new HashMap<Integer, String>();
        
        int N = 0;
        for (int i = 0; i < listA.length; i++) {
            if (!hashMap.containsKey(listA[i])) {
                hashMap.put(listA[i], N);
                name.put(N, listA[i]);
                N++;
            }
            
            if (!hashMap.containsKey(listB[i])) {
                hashMap.put(listB[i], N);
                name.put(N, listB[i]);
                N++;
            }
        }
        
        int[] f = new int[N];
        
        for (int i = 0; i < N; i++) {
            f[i] = i;
        }
        
        for (int i = 0; i < listA.length; i++) {
            int fa = find(hashMap.get(listA[i]), f);
            int fb = find(hashMap.get(listB[i]), f);
            
            if (fa != fb) {
                f[fa] = fb;
            }
        }
        
        int[] count = new int[N];
        int v = 0, idx = 0;
        for (int i = 0; i < N; i++) {
            f[i] = find(i, f);
            count[f[i]]++;
            if (count[f[i]] > v) {
                v = count[f[i]];
                idx = f[i];
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (f[i] == idx) {
                ans.add(name.get(i));
            }
        }
        return ans;
    }
    
    private int find(int x, int[] father) {
        if (father[x] != x) {
            father[x] = find(father[x], father);
        }
        return father[x];
    }
}
