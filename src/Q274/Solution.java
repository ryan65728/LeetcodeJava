package Q274;

import java.util.Arrays;

class Solution {
   /* public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0,temp = 0;
        for(int i = citations.length-1;i >= 0;i--)
        {
        	count++;
        	if(count == citations[i]) 
        	{
        		return count;        		
        	}
        	else if(count > citations[i])
        	{
        		count = Math.min(count-1, temp);
        		break;
        	}
        	temp = citations[i];
        }
        return count;
    }*/ //brute force 39.5%
	
	public int hIndex(int[] citations) 
	{
		int higher_len_count = 0;
		int length = citations.length;
		int [] count = new int [citations.length+1];
		for(int i = 0;i < length;i++)
		{
			if(citations[i] >= length) 
			{
				higher_len_count++;	
				System.out.println("higher_len_count:"+higher_len_count);
			}
			else 
			{
				count[citations[i]]++;
				System.out.println("count["+citations[i]+"]:"+count[citations[i]]);
			}
		}
		
		int i = 0;
		for(i = length;i >= 0;i--)
		{
			higher_len_count += count[i];
			if(higher_len_count >= i)
				break;							
		}
		return i;
	}
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {1};
		int   result = a.hIndex(testCase);
		//for(Integer i:result)
		{
			System.out.print(" "+result);
		}
		
	 }
}