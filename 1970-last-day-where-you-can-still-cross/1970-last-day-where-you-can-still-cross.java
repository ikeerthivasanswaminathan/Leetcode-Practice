class Solution 
{
    public int latestDayToCross(int row, int col, int[][] cells) 
    {
        int left = 0, right = cells.length;
        int ans = 0;
        while (left <= right) 
        {
            int mid = (left + right) / 2;
            if (canCross(row, col, cells, mid)) 
            {
                ans = mid;
                left = mid + 1;
            }
            else 
            {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) 
    {
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < day; i++) 
        {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = true;
        }
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int c = 0; c < col; c++) 
        {
            if (!grid[0][c]) 
            {
                q.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) 
        {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == row - 1)
            {
                return true;
            }
            for (int[] d : dir) 
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc] && !grid[nr][nc]) 
                {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}