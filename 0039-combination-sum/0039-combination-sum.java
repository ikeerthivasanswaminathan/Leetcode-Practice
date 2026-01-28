class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int target, int index,
                           List<Integer> path, List<List<Integer>> result) 
                           {
        if (target == 0) 
        {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) 
        {
            return;
        }

        for (int i = index; i < arr.length; i++) 
        {
            path.add(arr[i]);
            backtrack(arr, target - arr[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }
}