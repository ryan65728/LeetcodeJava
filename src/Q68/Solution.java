package Q68;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> result = new ArrayList<String>();
    	List<String> temp = new ArrayList<String>();
    	int spaceCount = 0,oneLineLength = 0;
    	for(int i = 0;i < words.length;i++)
    	{    	
    		if(words[i].length() + oneLineLength > maxWidth)
    		{
    			oneLineLength -= spaceCount;
    			spaceCount--;
    			result.add(mergeString(temp,oneLineLength,spaceCount,maxWidth));
    			
    			oneLineLength = 0;
    			spaceCount = 0;
    			temp.clear();
    		}
    		
    		if(words[i].length() + oneLineLength == maxWidth)
    		{
    			oneLineLength += words[i].length();
    			oneLineLength -= spaceCount;
    			temp.add(words[i]); 

    			result.add(mergeString(temp,oneLineLength,spaceCount,maxWidth));   			
    			oneLineLength = 0;
    			spaceCount = 0;
    			temp.clear();
    		}    		
    		else if(words[i].length() + oneLineLength < maxWidth )
    		{
    			spaceCount++;
    			oneLineLength += (words[i].length()+1);//1 for space
    			temp.add(words[i]);   			
    		}
    	}
    	
    	if(!temp.isEmpty())
    	{
    		String lastLine = "";
    		int remainer_length = 0;
        	for(Iterator<String> it = temp.iterator();it.hasNext();)
        	{
        		String temp_s = it.next();
        		remainer_length += temp_s.length();
        		lastLine += temp_s;
        		if(remainer_length < maxWidth) 
        		{
        			lastLine+= " ";
        			remainer_length++;
        		}
        	}
        	
        	for(int i = 0; i < maxWidth-remainer_length;i++)
        		lastLine+= " ";
        	
        	result.add(lastLine);

    	}
    	
    	return result;
    }
    
    public String mergeString(List<String> target,int length,int spaceCount,int maxWidth)
    {
    	
    	if(target.size() == 1)
    			spaceCount = 1;
    	int q = (maxWidth-length)/spaceCount,r = (maxWidth-length)%spaceCount;
    	//System.out.println("length = "+length+" spaceCount = " + spaceCount+ " q = "+ q +" r = "+r);
    	String space = "",result = "";
    	for(int i = 0;i < q;i++)
    		space += " ";
       	
    	for(Iterator<String> it = target.iterator();it.hasNext();)
    	{
    		result+=it.next();
    		if(spaceCount > 0)
    		{
    			result+=space;
    			spaceCount--;
    		}
    		
    		if(r > 0)
    		{
    			result+=" ";
    			r--;
    		}
    	}
    	
    	return result;
    }
}