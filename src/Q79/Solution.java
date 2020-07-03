package Q79;

import java.util.Stack;

class Solution {
	Stack<String> dfsList = new Stack<String>();
	boolean result = false;
    public boolean exist(char[][] board, String word) {
    	if(board.length < 1 || board.length> 200 || board[0].length < 1 || board[0].length > 200 || word.length() < 1 || word.length() > 1000)
    		return false;
    	//System.out.printf("row = "+ board.length+" column = "+board[0].length+" word'length = "+word.length());
        for(int i = 0;i < board.length;i++)
        {
        	for(int j = 0; j < board[0].length;j++)
        	{
        		//boolean[][] walked = new boolean[board.length][board[0].length];
        		dfs(board,i,j,0,word);
        		if(result)
        			return result;
        	}
        }
        return result;
    }
    
    void dfs(char[][] board,int i, int j,int n,String word)
    {
    	if(word.charAt(n) == board[i][j] && !result)
    	{
    		//System.out.println("board["+i+"]["+j+"]:"+board[i][j]+" same with "+word+"'"+word.charAt(n));
    		char temp = board[i][j];
    		board[i][j] = '*';
    		if(n == word.length()-1)
    		{
    			result = true;
    			return;
    		}
    		if(j+1 < board[0].length ) 
    			dfs(board,i,j+1,n+1,word);
    		if(j-1 >= 0)
    			dfs(board,i,j-1,n+1,word);

    		if(i+1 < board.length)
    			dfs(board,i+1,j,n+1,word);

    		if(i-1 >= 0 )
    			dfs(board,i-1,j,n+1,word);
    		
    		board[i][j] = temp;

    	}

    }
    
}
