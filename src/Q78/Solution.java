package Q78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>() ;
        int n = nums.length;
        for(int i= 0;i < Math.pow(2,n);i++)
        {
        	List<Integer> temp = new ArrayList<Integer>();
        	//System.out.println("Add ");
        	for(int j = 0;(i >> j) > 0;j++)
        	{
        		if((i >> j) % 2 == 1) {
        			temp.add(nums[j]);
        			//System.out.printf(nums[j]+" ("+i+">>"+j+")="+(i >> j) % 2);
        		}
        	}
        	result.add(new ArrayList<Integer>(temp));
        	temp.clear();
        }
        return result;
    }
}
