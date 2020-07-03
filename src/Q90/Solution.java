package Q90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Solution {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	int[] repeat_array;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	int n = nums.length;
    	if(n < 1)
    		return result;
    	repeat_array = new int[n];
        Arrays.sort(nums);
        for(int i = 0;i < n;i++)
        {
			if(i != 0 && nums[i] == nums[i-1]) 
			{
				//System.out.printf("n["+i+"] = "+nums[i]+" n[i-1] = "+nums[i-1]+" ");	
				repeat_array[i] = repeat_array[i-1]+1;
			}
			else
				repeat_array[i] = 1;
			//System.out.printf("r["+i+"]="+repeat_array[i]+" ");	
        }

        for(int i = n-1;i >= 0;i--)
        {
        	int index = i-repeat_array[i]+1;
        	//System.out.println("swap from r["+i+"]="+repeat_array[i]+" to r["+index+"]="+repeat_array[index]);	
        	reverse(repeat_array,index,i);
        	i = index;
        }
        subset_(nums,0,new ArrayList<Integer>());
        return result;
    }
    
    void reverse(int repeat_array[],int start,int end)
    {
    	if(end-start > 0)
    	{
    		for(int i = 0;i < (end-start+1)/2;i++)
    		{
    			int temp = repeat_array[start+i];   			
    			repeat_array[start+i] = repeat_array[end-i];
    			repeat_array[end-i] = temp;
    			//System.out.println("swap "+repeat_array[start+i]+" and "+repeat_array[end-i]);
    		}
    	}
    }
    
    void subset_(int[] nums,int n,List<Integer> a)
    {
 /*   	System.out.println("n = "+n);
		Iterator<Integer> jt = a.iterator();
		while(jt.hasNext())
		{
			System.out.printf(jt.next()+" ");
		}*/
    	if(n < nums.length) {
    		ArrayList<Integer> temp = new ArrayList<Integer>(a);
    		temp.add(nums[n]);
    		subset_(nums,n+1,new ArrayList<Integer>(temp));
    		temp.remove(temp.size()-1);
    		//System.out.println("remove = "+temp.remove(temp.size()-1)+" go to r_a["+n+"-"+repeat_array[n]+"+1]="+repeat_array[n-repeat_array[n]+1]+"+"+n);
    		subset_(nums,n+repeat_array[n],new ArrayList<Integer>(temp));			
    		
    	}
    	else {
    		result.add(new ArrayList<Integer>(a));
    		return;
    	}
    }
}
