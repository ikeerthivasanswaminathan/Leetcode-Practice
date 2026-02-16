class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int left=0;
        int right=nums.length-1;
        while(left<=right && nums[left]!=target)
        {
            left++;
        }
        while(left<=right && nums[right]!=target)
        {
            right--;
        }
        if (left<=right && nums[left]==target && target==nums[right])
        {
            return new int[]{left,right};
        }
        else
        {
            return new int[]{-1,-1};
        }
    }
}