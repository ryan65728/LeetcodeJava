package Q60;

import java.util.LinkedList;

class Solution {
    public String getPermutation(int n, int k) {
    	int quotient = 0, remainder = k;
    	LinkedList<Integer> dataElement = new LinkedList<Integer>();
    	int [] factorial = new int[10];
    	String ans = "";
    	
    	for(int i = 1;i <= n;i++)
    		dataElement.add(i);
    	
    	for(int i = 1;i <= n;i++)
    	{
    		if(i == 1)
    			factorial[1] = 1;
    		else
    			factorial[i] = factorial[i-1]*i;
    	}
    	
    	if( n < 1 || n > 9 || k > factorial[n] )//input range check Ryan20200523
    		return ans;
    	if(n == 1)
    		return "1";
    	    	
    	for(int i = 1;;i++)
    	{
    		quotient = remainder/factorial[n - i];//every position is from
    		remainder = remainder%factorial[n - i];
    		
    		if(remainder == 0) 
    		{
    			ans += dataElement.remove(quotient-1);
    			while(!dataElement.isEmpty())
    			    ans += dataElement.removeLast();  			
    			break;
    		}
    		else
    		    ans += dataElement.remove(quotient);
   		
    	}
    	   	
    	return ans;     
    }
}