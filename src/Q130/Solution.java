package Q130;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if(row < 1)
        	return ;
        int column = board[0].length;
        List<Set<pair>> allSet = new ArrayList<Set<pair>>();
        List<Boolean> isEdge = new ArrayList<Boolean>();
        
        for(int i = 0;i < row;i++)
        {
        	for(int j = 0;j < column;j++)
        	{
        		if(board[i][j] == 'O')
        		{
        			Set<pair> up_set = null,left_set = null,now_set = null;
        			boolean edge = false;
        			pair up = null;
        			pair left = null;
        			
        			if(i-1 >= 0) 
        				up = new pair(i-1,j);
        			else
        				edge = true;
        			
        			if(j-1 >= 0)
        				left = new pair(i,j-1);
        			else
        				edge = true;
        			
        			if(i+1 >= row || j+1 >= column)
        				edge = true;
        			
        			for(Set<pair> k:allSet) 
        			{
        				if(up != null && k.contains(up))
        					up_set = k;
        				if(left != null && k.contains(left))
        					left_set = k;
        			}
        			
        			if(up_set != null && left_set != null && up_set != left_set) 
        			{
        				int left_index = allSet.indexOf(left_set);       				
        				now_set = up_set;
        				now_set.addAll(left_set);
        				//System.out.println("Remove Set["+left_index+"]:");
        				now_set.add(new pair(i,j));
        				if(isEdge.get(left_index))
        					edge = true;
        				allSet.remove(left_index);
        				isEdge.remove(left_index);
        			}
        			else if(up_set != null) 
        			{
        				now_set = up_set;
        				now_set.add(new pair(i,j));    
        			}
        			else if(left_set != null) 
        			{
        			    now_set = left_set;  
        			    now_set.add(new pair(i,j)); 
        			}
        			else
        			{
        				now_set = new HashSet<pair>();  
        				now_set.add(new pair(i,j)); 
        				allSet.add(now_set);
        				isEdge.add(allSet.indexOf(now_set), edge);
        			}
        			//now_set.add(new pair(i,j));
        			int now_index = allSet.indexOf(now_set);
        	/*		System.out.println("Set["+now_index+"]:");
        			for(pair l:now_set)
        			{
        				System.out.printf("("+l.row+","+l.column+")");
        			}*/
        			isEdge.set(now_index, isEdge.get(now_index) || edge);
        		}
        	}
        }
        
        for(Set<pair> i:allSet)
        {
        	if(!isEdge.get(allSet.indexOf(i)))
        	{
        		for(pair j:i)
        			board[j.row][j.column] = 'X';
        	}
        }
    }
    
}

class pair
{
	public int row,column;
	pair(int row,int column)
	{
		this.row = row;
		this.column = column;
	}
	
	@Override
	public boolean equals(Object o) {
		  //System.out.printf("compare:"+(((pair)o).row == this.row && ((pair)o).column == this.column));
	      return ((pair)o).row == this.row && ((pair)o).column == this.column;
	}
	
    @Override
    public int hashCode() {
        return 41 * (41 + row) + column;
    }
}