package Q222;




import java.util.ArrayList;
import java.util.List;





 
class Solution {
	List<String> result ;
	int head,tail,length,start;

    public List<String> summaryRanges(int[] nums) {
        result = new ArrayList<String>();
        head = 0;
        start = 0;
        length = nums.length;
        tail = length - 1;
        if(length != 0)
        	search_internal(nums);
        return result;
    }

    public void search_internal(int[] nums)
    {
    	//System.out.println("Do nums["+head+"]:"+nums[head]+" and nums["+tail+"]:"+nums[tail]);
    	if(nums[head]+(tail-head) != nums[tail])
    	{
    		if(nums[head]+(tail-head)/2 < nums[(tail+head)/2]) 
    		{
    			if(head+1 == tail)
    				tail = head;
    			else
    				tail = (head+tail)/2;
    			search_internal(nums);
    		}
    		else
    		{
    			if(head+1 == tail)
    				tail = head;
    			else
    				head = (head+tail)/2;
    			search_internal(nums);
    		}
    		
    	}
    	else
    	{
    		if(start == tail)
    			result.add(""+nums[start]);
    		else
    			result.add(nums[start]+"->"+nums[tail]);

    		if(tail+1 == length)
    			return;
    		else 
    		{
    			start = tail+1;
        		head = start;
        		tail = length -1;
    			search_internal(nums);
    		}
    	}
    }
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {1,2,3,4,5,8,9};
		List<String>  result = a.summaryRanges(testCase);
		for(String i:result)
		{
			System.out.println("ans = "+i);
		}
		
	 }
}