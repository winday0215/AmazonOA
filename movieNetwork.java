public class Solution {
    /**
     * @param rating: the rating of the movies
     * @param G: the realtionship of movies
     * @param S: the begin movie
     * @param K: top K rating 
     * @return: the top k largest rating moive which contact with S
     */
    public class Pair {
        public int rating;
        public int index;
        public Pair(int rating, int index) {
            this.rating = rating;
            this.index = index;
        }

    }
    
    public static Comparator<Pair> idComparator = new Comparator<Pair>(){
        @Override
        public int compare(Pair c1, Pair c2) {
            return c2.rating - c1.rating;
        }  
    };
    public void dfs(int[] rating, int[][] G,int x, int S, Queue<Pair> pq, boolean[] visit) {
        if(visit[x] == true) {
            return;
        }
        visit[x] = true;
        if(x != S) {
            pq.add(new Pair(rating[x], x));
        }
        for(int i = 0; i < G[x].length; i++) {
            dfs(rating, G, G[x][i], S, pq, visit);
        }
    }
    
     
    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        // Write your code here
        Queue<Pair> pq =  new PriorityQueue<Pair>(K,idComparator);
        boolean[] visit = new boolean[rating.length];
        dfs(rating, G, S, S, pq, visit);
        int[] ans = new int[K];
        for(int i = 0; i < K; i++) {
            if(!pq.isEmpty()) {
                Pair top = pq.poll();
                ans[i] = top.index;
            }
        }
        return ans;
    }
}
