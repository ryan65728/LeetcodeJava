package Q56;

import java.util.Iterator;
import java.util.LinkedList;

class Solution {
	Interval [] array;
   
    public int[][] merge(int[][] intervals) {
    	 int n = intervals.length;
    	// System.out.println("length:"+n+",j= "+intervals[n-1].length);
    	 if(n<=1)
    		 return intervals;  
    	 if(intervals[n-1].length <= 0 || intervals[n-1].length > 2)
    		 return null;
	 
    	 
    	 array = new Interval[n];
    	 //
    	 for(int i = 0;i < n;i++)
    		 array[i] = new Interval(intervals[i][0],intervals[i][1]);

    	 
    	 
    	 merge_sort(0,n);
    	 
    	 LinkedList<Interval> result = new LinkedList<Interval>();
    	 result.add(array[0]);
    	 for(int i = 1 ;i < n;i++)
    	 {
    		 Interval temp = result.removeLast();
    		 if(temp.get_right() < array[i].get_left())
    		 {
    			 result.add(new Interval(temp));
    			 result.add(new Interval(array[i]));
    		 }
    		 else if(array[i].get_right() <= temp.get_right() )
    		 {
    			 result.add(new Interval(temp));
    		 }
    		 else
    		 {
    			 result.add(new Interval(temp.get_left(),array[i].get_right()));
    		 }
    	 }
    	 
    	 int result_n = result.size();
    	 int[][] result_int = new int [result_n][2];
    	 
    	 Iterator<Interval> it = result.iterator();
    	 
    	 for(int i = 0;i < result_n;i++)
    	 {
    		 Interval temp = it.next();
    		 result_int[i][0] = temp.get_left();
    		 result_int[i][1] = temp.get_right();
    	 }
    	 
    	 
    	 return result_int;
    }
    
	public int merge_sort(int head,int length)
    {	   
    	if(length == 1) 
    	{
    		return head;
    	}
    	else
    	{
    		int half = (int)Math.ceil(((double)length)/2);
    		int l = merge_sort(head, half);
    		int r = merge_sort(head+half, length - half);
    		LinkedList<Interval> temp = new LinkedList<Interval>();
    		
    		for(int i = 0;i < length;i++)
    		{
    			if(r >= head+length)
    			{
    				temp.add(new Interval (array[l]));
    				l++;
   				
    			}
    			else if(l >= head+half)
    			{
    				temp.add(new Interval (array[r]));
    				r++;
    			}
    			else if(array[l].get_left() > array[r].get_left())//.compareL(array[r]) == ComType.BIG )
    			{
    				temp.add(new Interval (array[r]));
    				r++;
    			}
    			else
    			{
    				temp.add(new Interval (array[l]));
    				l++;
    			}

    		}
    		Iterator<Interval> it = temp.iterator();

    		for(int i = head;i < head+length && it.hasNext();i++)
    			array[i].set(it.next());

    		return head;
    	}
    	
    }  
  
}

class Interval
{
	   private int left,right;
	   Interval()
	   {
		   left = -1;
		   right = -1;
	   }
	   Interval(int l,int r)
	   {
		   left = l;
		   right = r;
	   }
	   Interval(Interval copy)
	   {
		   left = copy.get_left();
		   right = copy.get_right();
	   }
	   void set(int l,int r)
	   {
		   left = l;
		   right = r;
	   }
	   void set(Interval copy)
	   {
		   left = copy.get_left();
		   right = copy.get_right();
	   }
	   
	   int get_left()
	   {
		   return left;
	   }
	   int get_right()
	   {
		   return right;
	   }
}

//int [] array = {3,2,3,2,2};
/*    public int[][] merge(int[][] intervals) {
   int n = intervals.length,chooseLeft = -1,chooseRight = -1,count = 0;
   boolean findLeft = true;
   int [][] result = new int [n][2];
   Parentheses [] intervals_set = new Parentheses[n];
   
   for(int i = 0;i < n;i++) 
   {
   	intervals_set[i] = Parentheses.UNUSED;
   }
   
   for(int i = 0;i < n;i++)
   {
   	if(intervals_set[intervals[i][0]] == Parentheses.UNUSED) {
   		intervals_set[intervals[i][0]] = Parentheses.LEFT ;
   	//	intervals_set[intervals[i][1]] = 2 ;
   	}
   	else if(intervals_set[intervals[i][0]] == Parentheses.RIGHT)
   	{
   		intervals_set[intervals[i][0]] = Parentheses.BOTH ;
   	}
   	
   	if(intervals_set[intervals[i][1]] == Parentheses.UNUSED)
   	{
   		intervals_set[intervals[i][1]] = Parentheses.RIGHT ;
   	}
   	else if(intervals_set[intervals[i][1]] == Parentheses.LEFT )
   	{
   		intervals_set[intervals[i][1]] = Parentheses.BOTH ;
   	}
   }
   
   for(int i = 0;i < n;i++) 
   {
   	System.out.println("intercals["+i+"]:"+intervals_set[i]);
   }
   
   for(int i = 0;i < n;i++) 
   {
   	if(findLeft && intervals_set[i] == Parentheses.LEFT && chooseLeft < 0)
   	{
   		chooseLeft = i;
   		System.out.println("Select Left "+chooseLeft);       		
   		findLeft = false;
   	}
   	else if(!findLeft)// && chooseRight > 0)
   	{       		
   		if(chooseRight > 0 && (intervals_set[i] == Parentheses.LEFT || i == n))
   		{
   			//save
   			System.out.println("Select ("+chooseLeft+","+chooseRight+")");
   			result[count][0] = chooseLeft;
   			result[count][1] = chooseRight;
   			count++;
   			chooseLeft = -1;
   			chooseRight = -1;
   		}
   		else if(intervals_set[i] == Parentheses.RIGHT || intervals_set[i] ==Parentheses.BOTH) 
   		{
   			
   			chooseRight = i;
   			System.out.println("Select Right "+chooseRight);
   		}
   	}
//   	else if(!findLeft && chooseRight < 0)
//   	{
//   		if(intervals_set[i] == Parentheses.RIGHT)
//   			chooseRight = i;
//   	}

   }
   
   return result;
}*/
