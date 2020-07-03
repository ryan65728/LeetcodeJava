package Q221;

class Solution {
    public int maximalSquare(char[][] matrix) {
    	int max = 0;
    	if(matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0))
    		return 0;
    	
        for(int i = 0;i < matrix.length;i++)
        {
        	for(int j = 0;j < matrix[0].length;j++)
        	{
        		if(matrix[i][j] != '0')
        		{
        			int temp = 0,check_temp = 0;
        			if(max == 0)max = 1;
        			if((i-1)>=0 && (j-1)>=0)
        			{
        				check_temp = Math.min(matrix[i-1][j-1]-'0',Math.min(matrix[i-1][j]-'0',matrix[i][j-1]-'0'));
        				if(check_temp > 0) 
        				{
        					temp = (int)check_temp+1;
        					matrix[i][j] = (char)(temp+'0');
        				}
        			}
        			max = Math.max(max, temp);
        		}
        	}
        }
        return max*max;
    }
}
