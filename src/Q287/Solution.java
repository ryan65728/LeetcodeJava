package Q287;


 
class Solution {
    public int findDuplicate(int[] nums) {
        int a = 0,b = 1;
    	while(a!=b)
        {
    		if(a == 0)
    			b = 0;
        	a = nums[a];
        	b = nums[nums[b]];
        }
    	a = 0;
    	
    	while(a != b)
    	{
    		a = nums[a];
    		b = nums[b];
    	}
    	return b;
    }
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {1,4,3,4,5,2};
		int  result = a.findDuplicate(testCase);
		//for(Integer i:result)
		{
			System.out.print(" "+result);
		}
		
	 }
}