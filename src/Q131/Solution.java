package Q131;

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<List<String>> result = new ArrayList<List<String>>();
	List<String> path = new ArrayList<String>();
	boolean[][] dp = null;
    public List<List<String>> partition(String s) {
    	int length = s.length();
    	if(length == 0) {
    		result.add(path);
    		return result;
    	}
        dp = new boolean[length][length];
        partition_recursive(s,0,length);
        return result;
    }
    
    public void partition_recursive(String s,int start,int length)
    {
    	if(start >= length)
    		return ;
    	for(int i = start;i <= length-1;i++) {
    		if(dp[start][i] || isPalindrome(s,start,i))
    		{
    			dp[start][i] = true;
    			path.add(s.substring(start, i+1));
    			if(i == length-1)
    			{
    				result.add(new ArrayList<String>(path));
    			}
    			partition_recursive(s,i+1,length);
    			path.remove(path.size()-1);
    		}
    	}
    }
    
    public boolean isPalindrome(String s,int start,int end)
    {
        while(start < end)
        {
        	if(s.charAt(start++) != s.charAt(end--))
        		return false;
        }
        return true;
    }
}