class Solution 
{
    public void sortColors(int[] nums) 
    {
        int z=0, o=0, t=0, i=0;
        for (int num : nums)
        {
            if (num==0)
            {
                z++;
            }
            else if (num==1)
            {
                o++;
            }
            else if (num==2)
            {
                t++;
            }
        }
        while(z-- > 0)
        {
            nums[i++]=0;
        }
        while (o-- > 0)
        {
            nums[i++]=1;
        }
        while (t-- > 0)
        {
            nums[i++]=2;
        }
    }
}