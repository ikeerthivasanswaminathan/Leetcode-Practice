class Solution 
{
    public int calPoints(String[] operations) 
    {
        Stack<Integer> stack=new Stack<>();
        for(String op:operations)
        {
            if(op.equals("+"))
            {
                int score=stack.pop();
                int newscore=score+stack.peek();
                stack.push(score);
                stack.push(newscore);
            }
            else if(op.equals("C"))
            {
                stack.pop();
            }
            else if(op.equals("D"))
            {
                stack.push(2*stack.peek());
            }
            else
            {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum=0;
        for(int num:stack)
        {
            sum+=num;
        }
        return sum;
    }
}