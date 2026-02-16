class Solution 
{
    public int maximumWealth(int[][] accounts) 
    {
        int sum=0;
        int max=0;
        for (int[] row : accounts) 
        {
            sum=0;
            for (int value : row) 
            {
                sum=sum+value;
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}