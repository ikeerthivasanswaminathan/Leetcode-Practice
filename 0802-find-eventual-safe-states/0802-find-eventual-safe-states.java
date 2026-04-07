class Solution 
{
    public java.util.List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int n = graph.length;
        java.util.List<Integer>[] rev = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) 
        {
            rev[i] = new java.util.ArrayList<>();
        }
        int[] outdegree = new int[n];
        for (int i = 0; i < n; i++) 
        {
            outdegree[i] = graph[i].length;
            for (int v : graph[i]) 
            {
                rev[v].add(i);
            }
        }
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) 
        {
            if (outdegree[i] == 0) 
            {
                q.add(i);
            }
        }
        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) 
        {
            int node = q.poll();
            safe[node] = true;
            for (int parent : rev[node]) 
            {
                outdegree[parent]--;
                if (outdegree[parent] == 0) 
                {
                    q.add(parent);
                }
            }
        }
        java.util.List<Integer> ans = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            if (safe[i]) 
            {
                ans.add(i);
            }
        }
        return ans;
    }
}