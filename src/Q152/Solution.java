package Q152;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxProduct(int[] nums) {
    	int n = nums.length;
    	List<Integer> negativeList = new ArrayList<Integer>(); 
    	if(n == 0)
    		return 0;
    	int result = Integer.MIN_VALUE;
    	int l = -1;
    	int i = 0;

    	for(i = 0;i < n;i++)
    	{
    		result = Math.max(result,nums[i]);
    		if(nums[i] == 0)
    		{    			
    			if(!negativeList.isEmpty())
    			{
    				if(negativeList.size()%2 == 0)   					
    					result = Math.max(result, section(nums,l,i-1));
    				else
    				{
    					//System.out.printf(" i:"+negativeList.get(0)+" l = " +l);
    					result = Math.max(result,section(nums,negativeList.get(0)+1,i-1));
    					//System.out.printf("section("+(negativeList.get(0)+1)+","+(i-1)+"):"+section(nums,negativeList.get(0)+1,i-1));
    					result = Math.max(result,section(nums,l,negativeList.get(0)-1));
    					result = Math.max(result,section(nums,negativeList.get(negativeList.size()-1)+1,i-1));
    					result = Math.max(result,section(nums,l,negativeList.get(negativeList.size()-1)-1));
    				}
    				negativeList.clear();
    			}
    			else
    			{
    				if(l != -1)
    					result = Math.max(result, section(nums,l,i-1));
    			}
    			l = -1;
    		}
    		else
    		{
    			if(l == -1)
    				l = i;
    			if(nums[i] < 0 )
    				negativeList.add(i);
    		}
    	}
    		   
    	if(l != -1)
    	{
			if(!negativeList.isEmpty())
			{
				if(negativeList.size()%2 == 0)   					
					result = Math.max(result, section(nums,l,i-1));
				else
				{
					//System.out.printf(" i:"+negativeList.get(0)+" l = " +l);
					result = Math.max(result,section(nums,negativeList.get(0)+1,i-1));
					//System.out.printf("section("+(negativeList.get(0)+1)+","+(i-1)+"):"+section(nums,negativeList.get(0)+1,i-1));
					result = Math.max(result,section(nums,l,negativeList.get(0)-1));
					result = Math.max(result,section(nums,negativeList.get(negativeList.size()-1)+1,i-1));
					result = Math.max(result,section(nums,l,negativeList.get(negativeList.size()-1)-1));
				}
				negativeList.clear();
			}
			else
			{
				if(l != -1)
					result = Math.max(result, section(nums,l,i-1));
			}
    	}
    	
        return result;
    }
    public int section(int[] nums,int l,int r)
    {
    	if(l < r) 
    	{
    		int temp = 1;
    		for(int i = l;i <= r;i++)
    	    		temp *= nums[i];
    	
    		return temp;
    	}
    	else
    		return nums[0];
    }
}