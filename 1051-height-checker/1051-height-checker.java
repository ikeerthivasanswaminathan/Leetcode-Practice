class Solution
{
    public int heightChecker(int[] heights) 
    {
        int[] count = new int[101];
        for (int h : heights) 
        {
            count[h]++;
        }
        int index = 0;
        int mismatch = 0;
        for (int h = 1; h <= 100; h++) 
        {
            while (count[h]-- > 0) 
            {
                if (heights[index] != h) 
                {
                    mismatch++;
                }
                index++;
            }
        }
        return mismatch;
    }
}