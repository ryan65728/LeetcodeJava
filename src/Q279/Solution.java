package Q279;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int max_square = 1;
        dp[0] = 0;
        for(int i = 1;i <= n;i++)
        {
        	if(max_square*max_square == i)
        		max_square += 1;
        	int min = Integer.MAX_VALUE;
        	for(int j = max_square;j >= max_square/2;j--)
        	{   
        		if(j*j == i)
        		{
        			min = 1;
        			break;
        		}
        		else if(j*j < i)
        		{
        			min = Math.min(min, dp[i-j*j]+1);
        			//System.out.println("dp["+i+"-"+(j*j)+"]:"+dp[i-j*j]+"+1");
        		}
        	}
        	dp[i] = min;
        }
        for(int i = 0;i <= n;i++)
        {
        	System.out.println("dp["+i+"]:"+dp[i]);
        }
        
        return dp[n];
    }
}