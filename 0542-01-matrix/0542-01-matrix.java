class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (mat[i][j] == 0) 
                {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) 
        {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int k = 0; k < 4; k++) 
            {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) 
                {
                    vis[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}