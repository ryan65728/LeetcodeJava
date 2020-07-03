package Q80;

class Solution {
    public int removeDuplicates(int[] nums) {
        boolean appeared = false;
        int length = 1;
        if(nums.length < 2)
        	return nums.length;
        for(int i = 1;i < nums.length;i++)
        {
        	if(nums[i] == nums[i-1])
        	{
        		if(!appeared)
        		{
        		//	System.out.println("Appear twice["+i+"],["+(i-1)+"]");
        			appeared = true;
        			nums[length] = nums[i];
        			length++;
        		}
        	}
        	else
        	{
        	//	System.out.println("Appear once nums["+i+"]:"+nums[i]);
        		appeared = false;
        		nums[length] = nums[i];
        		length++;
        	}
        }
        
        return length;
    }

}