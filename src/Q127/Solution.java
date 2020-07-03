package Q127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	if(!wordList.contains(endWord))
    		return 0;
    	Queue<Integer> bfs = new LinkedList<Integer>();
    	List<Integer> working = new ArrayList<Integer>();
    	int[] path = new int[wordList.size()];
    	
    	for(int i = 0;i < path.length; i++) 
    	{
    		path[i] = Integer.MAX_VALUE;
    		working.add(i);
    	}
    	int endwordIndex = wordList.indexOf(endWord);
    	bfs.add(endwordIndex);
    	path[endwordIndex] = 0;
    	working.remove(endwordIndex);
    	
    	while(!bfs.isEmpty()) {
    		int temp = bfs.remove();
    		for(int i = 0;i < working.size();i++)
    		{			
    			int it = working.get(i);
    			if(diff(wordList.get(it),wordList.get(temp)) == 1 && (path[it] > path[temp]+1))
    			{    				
    				path[it] = path[temp]+1;
    				bfs.add(it);
    				working.remove(i);
    				i--;
    			}
    		}
    	}

    	for(int i = 0;i < path.length; i++)
    		System.out.println(wordList.get(i)+" path:"+path[i]);
    	
    	
    	int min = Integer.MAX_VALUE; 
    	for(int i = 0;i < path.length;i++)
    	{  		  	
    		if(path[i] < wordList.size())
    		{
    			int beginDiff = diff(beginWord,wordList.get(i));
    			if(beginDiff == 1)
    				min = Math.min(min,path[i]+1);
    			else if(beginDiff == 0)
    				min = Math.min(min,path[i]);
    		}
    	}
    	
    	if(min < Integer.MAX_VALUE )
    		return min+1;
    	else
    		return 0;
    }
    
    public int diff(String a,String b)
    {
		int diff = 0;
		for(int i = 0;i < a.length();i++)
		{
			if(a.charAt(i) != b.charAt(i))
				diff++;
			if(diff > 1)
				break;
		}
		return diff;
    }
    
 /*   class pair
    {
    	public int node,dis;
    	pair(int node,int dis)
    	{
    		this.node = node;
    		this.dis = dis;
    	}
    }*/
    
}
