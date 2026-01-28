class Solution 
{
    public int findNumbers(int[] nums) 
    {
        int[] arr=new int[nums.length];
        int numcount=0;
        for (int i=0;i<nums.length;i++)
        {
            int ans=nodigits(nums[i]);
            if(ans%2==0)
            {
                numcount++;
            }
        }
        return numcount;
    }
    private static int nodigits(int n)
    {
        int count=0;
        while(n!=0)
        {
            n=n/10;
            count++;
        }
        return count;
    }
}