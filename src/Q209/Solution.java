package Q209;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int len = nums.length;
    	int l = 0,r = 0;
    	int sum = 0, min = -1;
        while(r < len)
        {
        	while(sum < s && r < len)
        	{
        		sum+=nums[r];
        		r++;
        	}
        	while(sum >= s)
        	{
        		
        		min = (min > 0 ? Math.min(min, r-l):r-l);
        		sum -= nums[l];
        		l++;
        	}
        }
        return (min > 0? min:0);
    }
}