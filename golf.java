class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    trees.add(new int[]{h, i, j});
                }
            }
        }
        
        Collections.sort(trees, (a, b) -> a[0] - b[0]);
        
        int sr = 0, sc = 0;
        int ans = 0;
        for (int[] tree : trees) {
            int d = bfs(forest, sr, sc, tree[1], tree[2]);
            if (d < 0) {
                return -1;
            }
            ans += d;
            sr = tree[1];
            sc = tree[2];
        }
        return ans;
    }
    
    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int R = forest.size(), C = forest.get(0).size();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        
        q.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == tr && cur[1] == tc) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int newr = cur[0] + dx[i];
                int newc = cur[1] + dy[i];
                
                if (newr >= 0 && newr < R && newc >= 0 && newc < C && !visited[newr][newc] && forest.get(newr).get(newc) > 0) {
                    visited[newr][newc] = true;
                    q.offer(new int[]{newr, newc, cur[2] + 1});
                }
            }
        }
        
        return -1;
    }
}
