package Q77;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
    	CreateCom(k,1,new ArrayList<Integer>(),n);
    	return result;
    }
    
    public void CreateCom(int remainder,int startPos,List<Integer> record,int n)
    {

    	if(remainder == 0)
    	{
    		result.add(new ArrayList<Integer>(record));
    		record.clear();
    		return ;
    	}
    	else
    	{
    		for(int i = startPos; i + remainder -1 <= n ;i++)
    		{			
        		record.add(i);
        		CreateCom(remainder-1,i+1,new ArrayList<Integer>(record),n);
        		record.remove((Integer)i);
    		}

    	}
    }
}