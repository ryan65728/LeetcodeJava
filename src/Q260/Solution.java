package Q260;


 
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        int length = nums.length;
        for(int i = 1;i < length;i++)
        {
        	xor = xor^nums[i];
        }
        
        int lowestbit = xor&(-xor);
        int [] result = {0,0};
        for(int i =0;i < length;i++)
        {
        	if((nums[i]&lowestbit) > 0)
        		result[0] = result[0]^nums[i];
        	else
        		result[1] = result[1]^nums[i];
        }
        return result;
    }
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {1,2,1,1,3,1,2,4,4,5};
		int []  result = a.singleNumber(testCase);
		for(Integer i:result)
		{
			System.out.print(" "+i);
		}
		
	 }
}