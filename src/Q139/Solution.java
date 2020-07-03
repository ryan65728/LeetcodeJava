package Q139;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        
        dp[0] = true;

        for(int i = 0;i < s.length();i++)
        {
        	for(int j = 0;dp[i] &&j < wordDict.size();j++)
        	{
        		int total_length = wordDict.get(j).length()+i;
        		if(total_length <= s.length() && s.substring(i, total_length).equals(wordDict.get(j)))
        		{
        			dp[total_length] = true;
        		}
        	}
        }
        
        return dp[s.length()];
       // return dp[1][5];
    }
}
