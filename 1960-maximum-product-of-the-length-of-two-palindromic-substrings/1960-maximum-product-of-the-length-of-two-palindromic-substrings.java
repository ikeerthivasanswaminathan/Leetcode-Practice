class Solution 
{
    public long maxProduct(String s) 
    {
        int n = s.length();
        int[] d1 = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) 
        {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (0 <= i - k && i + k < n && s.charAt(i - k) == s.charAt(i + k)) 
            {
                k++;
            }
            d1[i] = k--;
            if (i + k > r) 
            {
                l = i - k;
                r = i + k;
            }
        }
        long[] left = new long[n];
        long[] right = new long[n];
        for (int i = 0; i < n; i++) 
        {
            left[i] = 1;
            right[i] = 1;
        }
        for (int i = 0; i < n; i++) 
        {
            int len = 2 * d1[i] - 1;
            int start = i - d1[i] + 1;
            int end = i + d1[i] - 1;
            left[end] = Math.max(left[end], len);
            right[start] = Math.max(right[start], len);
        }
        for (int i = n - 1; i > 0; i--) 
        {
            left[i - 1] = Math.max(left[i - 1], left[i] - 2);
        }
        for (int i = 1; i < n; i++) 
        {
            left[i] = Math.max(left[i], left[i - 1]);
        }
        for (int i = 0; i < n - 1; i++) 
        {
            right[i + 1] = Math.max(right[i + 1], right[i] - 2);
        }
        for (int i = n - 2; i >= 0; i--) 
        {
            right[i] = Math.max(right[i], right[i + 1]);
        }
        long maxProd = 0;
        for (int i = 0; i < n - 1; i++) 
        {
            maxProd = Math.max(maxProd, left[i] * right[i + 1]);
        }
        return maxProd;
    }
}