package Q238;


 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int L = 1;
        int [] result = new int[length];
        
        for(int i =length-1;i > 0;i--)
        {
        	if(i+1<length)
        		result[i] = result[i+1]*nums[i];
        	else
        		result[i] = nums[i];
        }
        
        for(int i =0;i < length;i++)
        {
        	if( i-1 >=0)
        		L = L*nums[i-1];
        	if(i+1 < length)
        		result[i] = L* result[i+1];
        	else
        		result[i] = L; 
        }
        return result;
    }
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {2,3};
		int []  result = a.productExceptSelf(testCase);
		for(Integer i:result)
		{
			System.out.print(" "+i);
		}
		
	 }
}