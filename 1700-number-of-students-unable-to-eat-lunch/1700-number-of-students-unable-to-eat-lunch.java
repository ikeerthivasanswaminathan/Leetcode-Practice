class Solution 
{
    public int countStudents(int[] students, int[] sandwiches) 
    {
        int zero = 0, one = 0;
        for (int s : students) 
        {
            if (s == 0) 
            {
                zero++;
            } 
            else 
            {
                one++;
            }
        }
        for (int sand : sandwiches) 
        {
            if (sand == 0) 
            {
                if (zero == 0) 
                {
                    return zero + one;
                }
                zero--;
            } 
            else 
            {
                if (one == 0) 
                {
                    return zero + one;
                }
                one--;
            }
        }
        return 0;
    }
}