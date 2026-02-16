class Solution 
{
    public int[] sortArray(int[] nums) 
    {
        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max = nums[i];
            }
            if(nums[i]<min)
            {
                min = nums[i];
            }
        }
        int range = max-min+1;
        int[] count = new int[range];
        for(int i=0;i<nums.length;i++)
        {
            count[nums[i]-min]++;
        }
        for(int i=1;i<range;i++)
        {
            count[i]+=count[i-1];
        }
        int[] output = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            output[count[nums[i]-min]-1] = nums[i];
            count[nums[i]-min]--;
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = output[i];
        }
        return nums;
    }
}