package Q120;

import java.util.List;

class Solution {
	int result = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        int high = triangle.size();
        System.out.println("High:"+high);
        int element_num = ((1+high)*high)/2,level_count = 1,bound = 1;
        int[] level = new int[element_num];
        int[] dp = new int[element_num];
        
        for(int i = 0;i <element_num;i++)
        {
        	level[i] = level_count;
        	//System.out.println("level["+i+"]:"+level_count+" pos["+i+"]:"+pos_count);
        	if(i+1 >= bound) 
        		bound+= (++level_count);

        }
        int i = 0,j = 0;
        for(List<Integer> list:triangle)
        {
        	for(Integer element: list)
        	{
        		if(i == 0)
        			dp[i] = element;
        		else
        		{
        			int min = Integer.MAX_VALUE;
        			if((i-level[i] >= 0) && level[i-level[i]] == level[i]-1)
        				min = Math.min(min, dp[i-level[i]]);
        			if(level[i-level[i]+1] == level[i]-1)
        				min = Math.min(min, dp[i-level[i]+1]);
        			dp[i] = min+element;
        			if(j == high-1)	
        				result = Math.min(result, dp[i]);
        		}
        		i++;
        	}
        	j++;
        }
        if(high == 1)
        	return dp[0];
        return result;
    }
}
