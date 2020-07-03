package Q300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int [nums.length+1];
        int j = 0;
        if(nums.length == 0)
        	return 0;
        
        dp[0] = Integer.MIN_VALUE;
        
        for(int i = 0;i < nums.length;i++)
        {

        		if(nums[i] > dp[j])
        		{
        			j++;
        			dp[j] = nums[i];
        		}
        		else
        		{
        		//	int insertIndex = Arrays.binarySearch(dp, 1, j+1, nums[i])+1;    
        			int insertIndex = binarySearch(dp, 1, j+1, nums[i])+1;   
        			//System.out.println("Seaech "+nums[i]+" from 1 to "+(j+1)+" get index:"+insertIndex+" ");
        			if(insertIndex == -1)
        			{
        				if(dp[1] > nums[i])
        					dp[1] = nums[i];
        			}
        			else if(insertIndex < -1)
        			{
        				insertIndex = Math.abs(insertIndex);
        				if(dp[insertIndex] > nums[i])
        					dp[insertIndex] = nums[i];
        			}

        		}
        }
        
        return j;
    }
    
    public int binarySearch(int[] nums,int start,int end,int target)
    {
    	int middle = 0;
    	
    	if(target < nums[start])
    		return -start-1;
    	
    	while(true)
    	{
			if(nums[start] == target)
				return start;
			else if(end < nums.length && nums[end] == target) 
				return end;
			
    		if(end-start < 2)
    			break;
    		
    		middle = (start+end)/2;
    		//System.out.println("start["+start+"]:"+nums[start]+" end["+end+"]:"+nums[end]+" middle:"+middle);  		
    		if(nums[middle] < target)
    			start = middle;
    		else
    			end = middle;   		

    	}

    	return -end-1;
    }
}
