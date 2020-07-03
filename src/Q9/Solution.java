package Q9;

public class Solution {
	public boolean isPalindrome(int x) {
	        if(x < 0) return false;
	        else if (x >= 0 && x < 10)return true;
	        else 
	        {
	        	int digtial_count = 0;
	        	int [] digit = new int[10];
	        	for(digtial_count = 0;x != 0;digtial_count++,x = x/10)
	        	{
	        		digit[digtial_count] = x%10;
	        		//System.out.printf("digit[%d] = %d \n",digtial_count,digit[digtial_count]);
	        	}
	        	int i = 0,j = digtial_count-1;
	        	for(i = 0,j = digtial_count-1;i+2 < j;i++,j--)
	        	{
	        		if(digit[i] != digit[j])return false;
	        	}
	        	
	        	if(digit[i] != digit[j])//odd or even use same statement
	        	{
	        		return false;
	        	}
	        	else return true;
	        }
	    }
}
