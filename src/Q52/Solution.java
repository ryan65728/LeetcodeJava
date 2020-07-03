package Q52;


import java.util.Iterator;
import java.util.LinkedList;

class Solution {
	private LinkedList<Coordinate> nQueenPos = new LinkedList<Coordinate>();
//	private LinkedList<LinkedList<Coordinate>> allQueenPos = new LinkedList<LinkedList<Coordinate>>();
	private int nQueenNum = 0;
    public int totalNQueens(int n) {
    	//i <= Math.ceil(((double)n)/2)
    	boolean put_success = true;
    	if(n == 1)
    		return 1;
    	put_last_queen_piece(1,n);
        while(nQueenPos.getFirst().get_x() <= Math.ceil(((double)n)/2))
        {
        	int first_x = nQueenPos.getFirst().get_x(),latest_y = nQueenPos.getLast().get_y();
        	//System.out.println("Qp size = "+nQueenPos.size());
        	if(put_success) 
        	{
        	//	System.out.println("before level success now deal with"+(latest_y+1));
        		put_success = put_last_queen_piece(latest_y+1,n);
        	}
        	else 
        	{
        	//	System.out.println("before level fail now deal with"+latest_y);
        		put_success = put_last_queen_piece(latest_y,n);        		
        	}
     	       	
        	if(nQueenPos.size() == n)
        	{
        		if(first_x <= n/2)
        			nQueenNum += 2;
        		else
        			nQueenNum++;
        	//	allQueenPos.add(nQueenPos);
        		//nQueenPos.set(nQueenPos.size()-1,new Coordinate(nQueenPos.getLast().get_x()+1,i));
        		
            /*    for(Iterator<Coordinate> i = nQueenPos.iterator();i.hasNext();)
                {
                	Coordinate temp = i.next();
                	System.out.println("("+temp.get_x()+","+temp.get_y()+")");
                }*/
        		
        		put_success = put_last_queen_piece(latest_y,n);    
        	}
        }
        
        return nQueenNum;
    }
    boolean put_last_queen_piece(int y,int n)
    {
    	if(!nQueenPos.isEmpty())
    	{
    		boolean [] candidate = new boolean[n+1];
    		int check_from = 1;
    		for(int i=1 ;i <= n;i++)
    			candidate[i] = true;
    		if(nQueenPos.peekLast().get_y() == y)
    		{
    			Coordinate temp = nQueenPos.removeLast();
    			check_from = temp.get_x()+1;
    			if(check_from > n)
    				return false;
    			
    		}
    		
    		for(Iterator<Coordinate>  i = nQueenPos.iterator(); i.hasNext();)
    		{
    		    Coordinate temp = i.next(); 
				int leftBottom = temp.get_x() - (y - temp.get_y()), bottom = temp.get_x(),rightBottom = temp.get_x() + (y - temp.get_y());
				if(leftBottom >=1 && leftBottom <=n && candidate[leftBottom]) 
					candidate[leftBottom] = false;				
								
				if(bottom >=1 && bottom <=n && candidate[bottom])
					candidate[bottom] = false;
									
				if(rightBottom >=1 && rightBottom <=n && candidate[rightBottom]) 			
					candidate[rightBottom] = false;					
							
    		}
    		
    		for(;check_from <= n;check_from++)
    		{
    			if(candidate[check_from]) 
    			{
    				nQueenPos.add(new Coordinate(check_from,y));
    			//	System.out.println("find "+check_from+","+y);
    				return true;
    			}
    		}
    		
    		return false;
    	}
    	else
    	{
    		nQueenPos.add(new Coordinate(1,1));
    		return true;
    	}
    }
}

class Coordinate
{
	private int x,y;
	Coordinate(int x_pos, int y_pos)
	{
		x = x_pos;
		y = y_pos;
	}
	
	void set(int x_pos, int y_pos)
	{
		x = x_pos;
		y = y_pos;
	}
	
	int get_x()
	{
		return x;
	}
	
	int get_y()
	{
		return y;
	}
}