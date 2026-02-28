class Solution 
{
    public int distinctEchoSubstrings(String text) 
    {
        Set<String> set = new HashSet<>();
        int n = text.length();
        for (int len = 2; len <= n; len += 2) 
        {
            for (int i = 0; i + len <= n; i++) 
            {
                String first = text.substring(i, i + len / 2);
                String second = text.substring(i + len / 2, i + len);
                if (first.equals(second)) 
                {
                    set.add(text.substring(i, i + len));
                }
            }
        }
        return set.size();
    }
}