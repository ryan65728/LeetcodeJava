package Q72;

class Solution {
    public void setZeroes(int[][] matrix) {
    	int columnRecord = -1,rowRecord = -1,n = matrix.length;    	
    	int m = matrix[n-1].length;
    	if(m < 1)
    		return;
    	for(int i = 0;i < n;i++)
    	{
    		for(int j = 0;j < m;j++)
    		{
    			
    			if(columnRecord == -1)
    			{
    				if(matrix[i][j] == 0) 
    				{
    					columnRecord = i;
    					rowRecord = j;
    				}
    			}
    			
    			if(columnRecord > -1)
    			{
    				if(matrix[i][j] == 0)
    				{
    					matrix[columnRecord][j] = 0;
    					matrix[i][rowRecord] = 0;
    				}
    			}
    		}
    	}
    	
    	if(columnRecord == -1)
    		return ;
    	
    	for(int j = 0;j < m;j++)
    	{
    		if(matrix[columnRecord][j] == 0 && j != rowRecord)
    		{
    			for(int i = 0;i < n;i++)
    				matrix[i][j] = 0;
    		}
    	}
    	
    	for(int i = 0;i < n;i++)   	
    	{
    		if(matrix[i][rowRecord] == 0)
    		{
    			for(int j = 0;j < m;j++)
    				matrix[i][j] = 0;
    		}
    	}
    	
    	for(int i = 0;i < n;i++) 
    		matrix[i][rowRecord] = 0;
    }
}