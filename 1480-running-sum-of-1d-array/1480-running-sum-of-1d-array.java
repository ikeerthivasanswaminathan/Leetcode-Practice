class Solution
{
    public int[] runningSum(int[] nums)
    {
        int sum=0;
        int[] arr=new int[nums.length];
        int i=0;
        while(i<nums.length)
        {
            sum+=nums[i];
            arr[i]=sum;
            i++;
        }
        return arr;
    }
}