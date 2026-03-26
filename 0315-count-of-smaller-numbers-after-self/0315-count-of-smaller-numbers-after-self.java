class Solution 
{
    private int[] counts;
    public List<Integer> countSmaller(int[] nums) 
    {
        int n = nums.length;
        counts = new int[n];
        Integer[] idx = new Integer[n];    
        for (int i = 0; i < n; i++) 
        {
            idx[i] = i;
        }
        mergeSort(nums, idx, 0, n - 1);
        List<Integer> result = new ArrayList<>();
        for (int c : counts) 
        {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[] nums, Integer[] idx, int left, int right) 
    {
        if (left >= right)
        {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, idx, left, mid);
        mergeSort(nums, idx, mid + 1, right);
        merge(nums, idx, left, mid, right);
    }

    private void merge(int[] nums, Integer[] idx, int left, int mid, int right) 
    {
        Integer[] temp = new Integer[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        while (i <= mid && j <= right) 
        {
            if (nums[idx[j]] < nums[idx[i]]) 
            {
                rightCount++;
                temp[k++] = idx[j++];
            }
            else 
            {
                counts[idx[i]] += rightCount;
                temp[k++] = idx[i++];
            }
        }
        while (i <= mid) 
        {
            counts[idx[i]] += rightCount;
            temp[k++] = idx[i++];
        }
        while (j <= right) 
        {
            temp[k++] = idx[j++];
        }
        for (int p = 0; p < temp.length; p++) 
        {
            idx[left + p] = temp[p];
        }
    }
}