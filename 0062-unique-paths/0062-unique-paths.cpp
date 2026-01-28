#include <vector>
using namespace std;

class Solution
{
public:
    int uniquePaths(int m, int n) 
    {
        vector<int> aboveRow(n, 1);
        for (int i = 1; i < m; i++) 
        {
            vector<int> currentRow(n, 1);
            for (int j = 1; j < n; j++)
            {
                currentRow[j] = currentRow[j - 1] + aboveRow[j];
            }
            aboveRow = currentRow;
        }
        return aboveRow[n - 1];
    }
};