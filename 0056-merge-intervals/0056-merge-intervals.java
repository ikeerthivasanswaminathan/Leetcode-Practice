class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        if (intervals.length==0)
        {
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> merge=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for (int i=1;i<intervals.length;i++)
        {
            if (intervals[i][0]<=end)
            {
                end=Math.max(end,intervals[i][1]);
            }
            else
            {
                merge.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        merge.add(new int[]{start,end});
        return merge.toArray(new int[merge.size()][]);
    }
}