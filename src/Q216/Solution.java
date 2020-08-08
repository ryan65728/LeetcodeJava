package Q216;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<Integer> union = new HashSet<Integer>();
        Set<Integer> ex_union = new HashSet<Integer>();
        result = new ArrayList<List<Integer>>();
        for(int i = 1;i < 10;i++)
        {
        	ex_union.add(i);
        }
        search(union,ex_union,9,n,k);
        return result;
    }
    
    void search(Set<Integer> union,Set<Integer> ex_union,int max,int number,int times)
    {
    	if(times < 0)
    		return;
    	else
    		times--;

    	for(int i = max;i > 0;i--)
    	{
    		//System.out.println("search "+i + " num "+number);
    		if(!ex_union.contains(i))
    			continue;
    		else
    		{
    			if(i == number)
    			{
    				if(times == 0)
    				{
    					union.add(number);
    					ArrayList<Integer> tmpList = new ArrayList<Integer>();
    					tmpList.addAll(union);
    					result.add(tmpList);
    					union.remove(number);
    					return;
    				}
    				continue;
    			}
    			if(i > number)
    				continue;    	
    			//System.out.println("now leave "+number);
    			ex_union.remove(i);
    			union.add(i);
    			search(union,ex_union,i-1,number-i,times);
    			ex_union.add(i);
    			union.remove(i);
    		}
    		
    	}
    	
    }
}