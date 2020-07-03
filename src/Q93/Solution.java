package Q93;

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<String> result = new ArrayList<String>();
	int[] list = new int[5];
    public List<String> restoreIpAddresses(String s) {       
        levelStack(0,0,s.length(),s);
        return result;
    }
    public void levelStack(int level,int used,int length,String s)
    {
    	if(level == 4)
    	{
    		int temp = 0;
    		String ans = "";
    		for(int i = 1;i <= 4;i++) 
    		{   	
    			ans += s.substring(temp, temp+list[i]);  
    			if(i != 4)
    				ans+=".";
    			temp += list[i];
    			
    		}
    		result.add(ans);
    		return;
    	}
    	
    	for(int i = 1;i <= 3;i++)
    	{
    		if((length-used-i)>=0 && (4 - level-1)*3 >= (length-used-i) && (4 - level-1)*1 <= (length-used-i))
    		{
    			Integer temp = Integer.parseInt(s.substring(used, used+i));
    			if(temp >= 0 && temp <= 255 && temp >= (i == 1? 0 :Math.pow(10, i-1)))
    			{
    				list[level+1] = i;
    				levelStack(level+1,used+i,length,s);
    			}
    		}
    	}

    }    
}

