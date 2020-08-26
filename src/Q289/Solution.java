package Q289;


 
class Solution {
	public void gameOfLife(int[][] board) {
		int row = board.length;
        if(row == 0)
			return;
		int column = board[row-1].length;
        for(int i = 0;i < row;i++)
        {
        	for(int j = 0;j < column;j++)
        	{
        		int life= getNextGen(board,i,j,row,column);
        		if(life < 2 || life > 3); //
        		else if(life == 2)
        			board[i][j] |= (0x1 & board[i][j]) << 1;
        		else if(life == 3)
        			board[i][j] |= 0x1 << 1;
        	}
        }

        for(int i = 0;i < row;i++)
        {
        	for(int j = 0;j < column;j++)
        	{
        		board[i][j] = board[i][j]>>1;
        	}
        }
        
    }

	int getNextGen(int[][] board,int pos_x,int pos_y,int row,int column)
	{
		int count = 0;
		int x = 0;
		int y = 0;
		int [][] dir = {{-1,1},{0,1},{0,-1},{1,-1},{1,1},{1,0},{-1,-1},{-1,0}};
		for(int i = 0;i < dir.length;i++)
		{
			x = dir[i][0] + pos_x;
			y = dir[i][1] + pos_y;
			if(x < 0 || y < 0 || x >= row || y >= column)
				continue;
			else if((board[x][y]&0x1) == 1)
				count++;
		}
		return count;
	}
}