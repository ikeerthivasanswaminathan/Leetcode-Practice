class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result) 
    {
        if (temp.size() == nums.length) 
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) 
        {
            if (temp.contains(num))
            {
                continue;
            }
            temp.add(num);
            backtrack(nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}