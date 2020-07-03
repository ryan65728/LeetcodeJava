package Q62;

class Solution {
    public int uniquePaths(int m, int n) {
    	int big,small;
    	double result = 1;
        if(m > n)
        {
        	big = m - 1;
        	small = n - 1;
        }
        else
        { 
        	big = n - 1;
        	small = m - 1;
        }
        if(small == 0)
        	return 1;
        
        
        for(int i = big+small; i > big;i--)
        	result*=i;
                
        for(int i = small;i > 1;i--)
        	result/=i;
        
        return (int)result;
    }
}
