class Solution 
{
    public int superEggDrop(int k, int n) 
    {
        int moves = 0;
        int[] dp = new int[k + 1];
        while (dp[k] < n) 
        {
            moves++;
            for (int eggs = k; eggs >= 1; eggs--) 
            {
                dp[eggs] = dp[eggs] + dp[eggs - 1] + 1;
            }
        }
        return moves;
    }
}