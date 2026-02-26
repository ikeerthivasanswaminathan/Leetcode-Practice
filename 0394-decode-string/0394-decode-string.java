class Solution 
{
    public String decodeString(String s) 
    {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) 
            {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '[') 
            {
                countStack.push(num);
                strStack.push(cur);
                cur = new StringBuilder();
                num = 0;
            }
            else if (ch == ']') 
            {
                int k = countStack.pop();
                StringBuilder prev = strStack.pop();
                for (int j = 0; j < k; j++) prev.append(cur);
                cur = prev;
            }
            else 
            {
                cur.append(ch);
            }
        }
        return cur.toString();
    }
}