package Q81;

class Solution {
	boolean result = false;
    public boolean search(int[] nums, int target) {
    	int start = 0,end = nums.length-1;  
    	if(end < 0)
    		return false;
    	bin_search(nums,target,start,end);
    	return result;
    }
    
    public void bin_search(int[] nums, int target,int start,int end)
    {
    	if(result)return;
    	int middle,length = nums.length-1;// = Math.abs(unsearch_end - unsearch_start)/2;
    	
    	boolean cross = (end < start);
    	if(cross)
    		middle = (end+length-start)/2+start-length;
    	else
    		middle = (end-start)/2+start;
    	//System.out.println("search nums["+start+"]:"+nums[start]+" to nums["+end +"]:"+nums[end]+" and middle ="+middle);
    	if( target ==  nums[start] || target ==  nums[end] || target ==  nums[middle]) 
    	{
    		result = true;
    		return ;
    	}
    	if(Math.abs(end -start) <= 1 || start-length == end)
    		return ;
    	
    	if((nums[start] < nums[middle] && nums[middle] < nums[end]) )//start,middle,end relation are small,middle,big
    	{
    		if(target < nums[middle])
    			bin_search(nums,target,start,middle);
    		else
    			bin_search(nums,target,middle,end);
    	}
    	else if(nums[end] < nums[start] && nums[start] < nums[middle])
    	{
    		if(target < nums[middle] && target > nums[start])
    			bin_search(nums,target,start,middle);
    		else
    			bin_search(nums,target,middle,end);
    	}
    	else if(nums[middle] < nums[end] && nums[end] < nums[start])
    	{
    		if(target > nums[middle] && target < nums[end])
    			bin_search(nums,target,middle,end);
    		else
    			bin_search(nums,target,start,middle);
    	}
    	
    	if(nums[end] == nums[start])//start,middle,end relation are small,middle,big
    	{
    		if(nums[middle] > nums[end]) 
    		{
    			if(target > nums[middle] || target < nums[end])
    				bin_search(nums,target,middle,end);   			
    			else
    				bin_search(nums,target,start,middle);
    		}
    		else if(nums[middle] < nums[end])
    		{
    			if(target < nums[middle] || target > nums[end])
    				bin_search(nums,target,start,middle);
    			else
    				bin_search(nums,target,middle,end);  
    		}
    		else
    		{
    			bin_search(nums,target,start,middle);
    			bin_search(nums,target,middle,end);
    		}
    	}
    	else if(nums[middle] == nums[end])
    		bin_search(nums,target,start,middle);
    	else if(nums[middle] == nums[start])
    		bin_search(nums,target,middle,end);
    }
}