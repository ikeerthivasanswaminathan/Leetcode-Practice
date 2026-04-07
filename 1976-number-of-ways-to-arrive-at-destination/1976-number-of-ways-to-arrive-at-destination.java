class Solution 
{
    public int countPaths(int n, int[][] roads) 
    {
        int mod = (int)1e9 + 7;
        java.util.List<long[]>[] adj = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) 
        {
            adj[i] = new java.util.ArrayList<>();
        }
        for (int[] r : roads) 
        {
            adj[r[0]].add(new long[]{r[1], r[2]});
            adj[r[1]].add(new long[]{r[0], r[2]});
        }
        long[] dist = new long[n];
        java.util.Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        java.util.PriorityQueue<long[]> pq = new java.util.PriorityQueue<>
        (
            (a, b) -> Long.compare(a[1], b[1])
        );
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) 
        {
            long[] curr = pq.poll();
            int node = (int)curr[0];
            long d = curr[1];
            if (d > dist[node])
            {
                continue;
            }
            for (long[] nei : adj[node]) 
            {
                int next = (int)nei[0];
                long time = nei[1];
                if (dist[next] > d + time) 
                {
                    dist[next] = d + time;
                    ways[next] = ways[node];
                    pq.add(new long[]{next, dist[next]});
                } 
                else if (dist[next] == d + time) 
                {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        return (int)(ways[n - 1] % mod);
    }
}