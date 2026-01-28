class Solution
{
    public List<String> generateParenthesis(int n) 
    {
        List<String> ans = new ArrayList<>();
        helper(ans, "", n, n);
        return ans;
    }

    void helper(List<String> ans, String s, int open, int close) 
    {
        if (open == 0 && close == 0) 
        {
            ans.add(s);
            return;
        }

        if (open > 0) 
        {
            helper(ans, s + "(", open - 1, close);
        }

        if (close > open) 
        {
            helper(ans, s + ")", open, close - 1);
        }
    }
}