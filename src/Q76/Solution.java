package Q76;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
    	Map<String,Integer> table = new HashMap<String,Integer>();
    	Map<String,Integer> checkTable = new HashMap<String,Integer>();;
    	
    	int l = 0,r = 0,count = 0;
    	int[] result = {-1,l,r};
    	
    	if(t.length() == 0 || s.length() == 0)
    		return "";
    	
    	String nowString = "";
    	for(int i = 0;i < t.length();i++)
    	{
    		nowString = t.substring(i, i+1);
    		Integer index = table.get(nowString);
    		checkTable.put(nowString, 0);		
    		if(index == null)
    			table.put(nowString, 1);
    		else
    			table.put(nowString, index+1);
    		//System.out.printf(" t["+nowString+"] = "+table.get(nowString));
    		//System.out.printf(" checkt["+nowString+"] = "+checkTable.get(nowString));
    	}
    	
    	
    	while(r < s.length())
    	{
    		Integer showTimes = checkTable.get(s.substring(r, r+1));
    	//	System.out.printf(" R:"+s.substring(r, r+1)+"->"+showTimes);
    		if(showTimes != null)
    		{
    			if(showTimes < table.get(s.substring(r, r+1)))
    				count++;
    			checkTable.put(s.substring(r, r+1),showTimes+1);
    		}
    	//	System.out.printf(" count = "+count);
    		
    		while(count == t.length())
    		{
    			showTimes = checkTable.get(s.substring(l, l+1));
    			if(showTimes != null) 
    			{
    			//	System.out.printf(" L:"+s.substring(l, l+1)+"->"+showTimes);
    				checkTable.put(s.substring(l, l+1),showTimes-1);
        			if(showTimes-1 < table.get(s.substring(l, l+1)))
        				count--;
    			}
    			if(count != t.length())
    				if(result[0] == -1 || (r-l+1) < result[0])
    				{
    					result[0] = (r-l+1);
    					result[1] = l;
    					result[2] = r;
    				}
    			l++;
    		}
    		r++;
    	}
    	if(result[0] == -1)
    		return "";
    	else
    		return s.substring(result[1], result[1]+result[0]);
    }
}