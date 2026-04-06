class Solution 
{
    public String longestDupSubstring(String s) 
    {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) 
        {
            nums[i] = s.charAt(i) - 'a';
        }
        int low = 1, high = n - 1;
        int startIdx = -1;
        int maxLen = 0;
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            int start = check(nums, mid);
            if (start != -1) 
            {
                startIdx = start;
                maxLen = mid;
                low = mid + 1;
            }
            else 
            {
                high = mid - 1;
            }
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + maxLen);
    }

    private int check(int[] nums, int len) 
    {
        int n = nums.length;
        if (len == 0)
        {
            return 0;
        }
        long mod1 = 1_000_000_007;
        long mod2 = 1_000_000_009;
        long base1 = 31;
        long base2 = 37;
        long h1 = 0, h2 = 0;
        long p1 = 1, p2 = 1;
        for (int i = 0; i < len; i++) 
        {
            h1 = (h1 * base1 + nums[i]) % mod1;
            h2 = (h2 * base2 + nums[i]) % mod2;
            if (i < len - 1) 
            {
                p1 = (p1 * base1) % mod1;
                p2 = (p2 * base2) % mod2;
            }
        }
        Set<Long> seen = new HashSet<>();
        seen.add(h1 * mod2 + h2);
        for (int i = 1; i <= n - len; i++) 
        {
            h1 = (h1 - nums[i - 1] * p1 % mod1 + mod1) % mod1;
            h1 = (h1 * base1 + nums[i + len - 1]) % mod1;
            h2 = (h2 - nums[i - 1] * p2 % mod2 + mod2) % mod2;
            h2 = (h2 * base2 + nums[i + len - 1]) % mod2;
            long combined = h1 * mod2 + h2;
            if (seen.contains(combined)) 
            {
                return i;
            }
            seen.add(combined);
        }
        return -1;
    }
}