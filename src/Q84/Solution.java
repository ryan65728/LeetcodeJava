package Q84;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
    	Stack<pair> hStack = new Stack<pair>(); 
    	int result = 0;

    	for(int i = 0;i < heights.length;i++)
    	{    		
    		if(hStack.isEmpty())
    		{
    			hStack.push(new pair(heights[i],i,0));
    		}
    		else {
    				int add = 0;
    				while(!hStack.isEmpty() && hStack.peek().height > heights[i])
    				{
    					pair temp = hStack.pop();
    					//System.out.println("now  heights["+i+"]:"+heights[i]+" is small than heights[" + temp.pos +"]:"+temp.height);
    					result = Math.max((i - temp.pos + temp.add)*temp.height, result);  
    					add = ++add + temp.add;
    				}
    				//System.out.println("now push pair("+heights[i]+"),(" + (i-popTimes) +") ");
    				hStack.push(new pair(heights[i],i,add));
    		}
    	}
    	
    	int last_pos = -1;
    	if(!hStack.isEmpty()) 
    	{
    		last_pos = hStack.peek().pos;
    	}
    	
    	while(!hStack.isEmpty())
    	{
    		pair temp = hStack.pop();
    		//System.out.println("now calculate pair("+temp.height+"),("+temp.pos+") with i:"+i+ " is "+(i - temp.pos)*temp.height);
    		result = Math.max((last_pos - temp.pos +temp.add+1)*temp.height, result);
    	}
    	
    	return result;
    }
    
}

class pair {
	public int height,pos,add;
	pair(int h,int p,int a)
	{
		height = h;
		pos = p;
		add = a;
	}
}