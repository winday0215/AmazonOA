class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0) {
            return ans;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>((w1, w2)-> 
                                                             map.get(w1) != map.get(w2) ? map.get(w1) - map.get(w2) 
                                                             : w2.compareTo(w1));
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
