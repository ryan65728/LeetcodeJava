package Q71;

import java.util.Iterator;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String result = "";
        Stack<String> filePathStack = new Stack<String>();
        String []  temp = path.split("/");
        for(int i = 0;i < temp.length;i++)
        {
        	if(temp[i].equals("") || temp[i].equals(".") );
        	else if(temp[i].equals("..") )
        	{
        		if(!filePathStack.isEmpty())
        			filePathStack.pop();
        	}
        	else
        	{
        		filePathStack.push(temp[i]);
        	}
        }

        if(filePathStack.isEmpty())
        	return "/";
        else
        {
        	Iterator<String> it = filePathStack.iterator();
        	while(it.hasNext())
        	{
        		result+=("/"+it.next());
        	}
        	return result;
        }
    }
}
