class DinnerPlates 
{
    int cap;
    List<Stack<Integer>> stacks = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public DinnerPlates(int capacity) 
    {
        cap = capacity;
    }
    public void push(int val) 
    {
        while (!pq.isEmpty() && (pq.peek() >= stacks.size() || stacks.get(pq.peek()).size() == cap)) 
        {
            pq.poll();
        }
        if (!pq.isEmpty()) 
        {
            int i = pq.poll();
            stacks.get(i).push(val);
            if (stacks.get(i).size() < cap) 
            {
                pq.offer(i);
            }
        }
        else 
        {
            Stack<Integer> st = new Stack<>();
            st.push(val);
            stacks.add(st);
            if (cap > 1)
            {
                pq.offer(stacks.size() - 1);
            }
        }
    }

    public int pop() 
    {
        for (int i = stacks.size() - 1; i >= 0; i--) 
        {
            if (!stacks.get(i).isEmpty()) 
            {
                int v = stacks.get(i).pop();
                pq.offer(i);
                return v;
            }
        }
        return -1;
    }

    public int popAtStack(int index) 
    {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty())
        {
            return -1;
        }
        int v = stacks.get(index).pop();
        pq.offer(index);
        return v;
    }
}