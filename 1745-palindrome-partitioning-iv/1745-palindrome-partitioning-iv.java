class Solution 
{
    public boolean checkPartitioning(String s) 
    {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) 
        {
            for (int j = i; j < n; j++) 
            {
                if (s.charAt(i) == s.charAt(j)) 
                {
                    if (j - i <= 2) 
                    {
                        dp[i][j] = true;
                    } 
                    else 
                    {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        for (int i = 0; i < n - 2; i++) 
        {
            if (!dp[0][i])
            {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) 
            {
                if (dp[i + 1][j] && dp[j + 1][n - 1]) 
                {
                    return true;
                }
            }
        }
        return false;
    }
}