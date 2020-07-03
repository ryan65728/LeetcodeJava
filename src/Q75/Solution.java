package Q75;

class Solution {
    public void sortColors(int[] nums) {
        int zero_count = 0,one_count = 0;
        boolean twoNumExist = false;
        for(int i = 0;i < nums.length;i++)
        {
        	//System.out.print("\n nums["+i+"]:");
        	if(nums[i] == 0){  
        		//System.out.printf("0 set num["+zero_count+"] = 0,");
        		nums[zero_count] = 0;       			
        		
        		
        		if(one_count != 0) {
        			//System.out.printf("switch num["+(zero_count+one_count-1)+"] = 1,");
        			nums[zero_count+one_count] = 1;
        		}
        		zero_count++;
        	}
        	else if(nums[i] == 1) 
        	{
        		//System.out.printf("1 set num["+(zero_count+one_count)+"] = 1,");
        		nums[zero_count+one_count] = 1;
        		one_count++;      
        	}
        	else if(nums[i] == 2)
        	{
        		twoNumExist = true;
        	}
        	
    		if(twoNumExist) {
    			//System.out.printf("switch num["+i+"] = 2");
    			nums[i] = 2;
    		}
        }
    }

}