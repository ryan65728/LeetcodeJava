package Q63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null)
    		return 0;
    	int row = obstacleGrid.length;
    	int column = obstacleGrid[row - 1].length;
    	//System.out.printf("row = "+row+" column = "+ column);
    	if(row == 0 || column == 0)
    		return 0;
    	int [][] gridSolution = new int [row][column];
    	gridSolution[0][0] = 1;
        for(int i = 0;i < row;i++)
        {
        	for(int j = 0;j < column;j++)
        	{
        		if(obstacleGrid[i][j] == 1)
        		{
        			gridSolution[i][j] = 0;
        			continue;
        		}
        		
        		if(j - 1 >= 0)
        		{
        			gridSolution[i][j] += gridSolution[i][j-1];
        		}
        		
        		if(i - 1 >= 0)
        		{
        			gridSolution[i][j] += gridSolution[i-1][j];
        		}
        	}
        }
        return gridSolution[row - 1][column - 1];
    }
}
