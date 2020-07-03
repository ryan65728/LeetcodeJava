package Q35;

class Solution {
    public int searchInsert(int[] nums, int target)     {
    	int middle = 0;
    	int start = 0,end = nums.length;
    	
    	if(end == 0)
    		return 0;
    	if(target < nums[start])
    		return start;
    	
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

    	return end;
    }
}
