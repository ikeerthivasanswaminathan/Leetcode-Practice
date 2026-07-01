class Solution 
{
    public int bestRotation(int[] nums) 
    {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) 
        {
            int start = (i - nums[i] + 1 + n) % n;
            int end = (i + 1) % n;
            diff[start]--;
            diff[end]++;
            if (start > end) 
            {
                diff[0]++;
            }
        }
        int best = 0;
        int score = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) 
        {
            score += diff[k];
            if (score > maxScore) 
            {
                maxScore = score;
                best = k;
            }
        }
        return best;
    }
}