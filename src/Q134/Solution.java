package Q134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0,part = 0,head = 0;
        boolean available = false;
        for(int i = 0;i < gas.length;i++)
        {
        	int temp = gas[i] - cost[i];
        	if(!available)
        	{
        		if(temp >= 0)
        		{
        			available = true;
        			part = 0;
        			head = i;
        		}
        	}
        	
        	if(available)
        	{
        		part += temp;
        		if(part < 0)
        			available = false;
        	}
        	total += temp;
        }
        
        if(total >= 0)
        	return head;
        
        return -1;
    }
}