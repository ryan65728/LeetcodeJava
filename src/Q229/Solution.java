package Q229;

import java.util.ArrayList;
import java.util.List;

 
class Solution {
	List<Integer> result;
	 public List<Integer> majorityElement(int[] nums) {
	        int count1 = 1,count2 = 0,can1 = nums[0],can2 = nums[0];
	        result = new ArrayList<Integer>();
	        for(int i = 1;i < nums.length;i++)
	        {
	        	if(can1 == nums[i])
	        		count1++;
	        	else if(can2 == nums[i])
	        		count2++;
	        	else if(count1 == 0) 
	        	{
	        		can1 = nums[i];
	        		count1++;
	        	}
	        	else if(count2 == 0)
	        	{
	        		can2 = nums[i];
	        		count2++;
	        	}	 
	        	else
	        	{
	        		count1--;
	        		count2--;
	        	}
	        	               			        	
	        }
	        count1 = 0;
	        count2 = 0;
	        
	        
	        for(int i = 0;i < nums.length;i++)
	        {
	        	if(can1 == nums[i])
	        		count1++;
	        	else if(can2 == nums[i])
	        		count2++;	               			        	
	        }
	        
	        if(count1 > nums.length/3)
	        	result.add(can1);
	        if(count2 > nums.length/3)
	        	result.add(can2);
	        
	        return result;
	        	
	 }
	
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {3,2,3};
		List<Integer>  result = a.majorityElement(testCase);
		for(Integer i:result)
		{
			System.out.println("ans = "+i);
		}
		
	 }
}