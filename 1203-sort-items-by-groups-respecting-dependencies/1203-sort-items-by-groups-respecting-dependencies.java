class Solution 
{
    public int[] sortItems(int n, int m, int[] group, java.util.List<java.util.List<Integer>> beforeItems) 
    {
        for (int i = 0; i < n; i++) 
        {
            if (group[i] == -1) 
            {
                group[i] = m++;
            }
        }
        java.util.List<Integer>[] itemGraph = new java.util.ArrayList[n];
        java.util.List<Integer>[] groupGraph = new java.util.ArrayList[m];
        for (int i = 0; i < n; i++)
        {
            itemGraph[i] = new java.util.ArrayList<>();
        }
        for (int i = 0; i < m; i++)
        {
            groupGraph[i] = new java.util.ArrayList<>();
        }
        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];
        for (int i = 0; i < n; i++) 
        {
            for (int prev : beforeItems.get(i)) 
            {
                if (group[i] == group[prev]) 
                {
                    itemGraph[prev].add(i);
                    itemIndegree[i]++;
                } 
                else 
                {
                    groupGraph[group[prev]].add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        java.util.List<Integer> groupOrder = topoSort(groupGraph, groupIndegree, m);
        if (groupOrder.size() != m)
        {
            return new int[0];
        }
        java.util.List<Integer> itemOrder = topoSort(itemGraph, itemIndegree, n);
        if (itemOrder.size() != n)
        {
            return new int[0];
        }
        java.util.Map<Integer, java.util.List<Integer>> map = new java.util.HashMap<>();
        for (int g : groupOrder) 
        {
            map.put(g, new java.util.ArrayList<>());
        }
        for (int item : itemOrder) 
        {
            map.get(group[item]).add(item);
        }
        java.util.List<Integer> result = new java.util.ArrayList<>();
        for (int g : groupOrder) 
        {
            result.addAll(map.get(g));
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) 
        {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private java.util.List<Integer> topoSort(java.util.List<Integer>[] graph, int[] indegree, int size) 
    {
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        java.util.List<Integer> res = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) 
        {
            if (indegree[i] == 0) 
            {
                q.add(i);
            }
        }
        while (!q.isEmpty()) 
        {
            int u = q.poll();
            res.add(u);
            for (int v : graph[u]) 
            {
                indegree[v]--;
                if (indegree[v] == 0) 
                {
                    q.add(v);
                }
            }
        }
        return res;
    }
}