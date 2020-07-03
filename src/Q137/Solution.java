package Q137;

class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0,ans = 0;
        for(int i = 0;i < 32;i++)
        {
        	sum = 0;
        	for(int num:nums)
        	{
        		sum += ((num>>i)&1);
        	}
        	if(sum%3 != 0)
        	{
        		ans = ans|(1<<i);
        	}
        }
        return ans;
    }
}
