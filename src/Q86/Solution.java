package Q86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = null,bigHead = null,smallTail = null,bigTail = null;
        int  previousNum = 0;
       // int j = 0;
        if(head != null && head.next != null) {   	
        	
        	if(head.val >= x) 
        	{
        		bigHead = head;
        		bigTail = head;
        	}
        	else
        	{
        		smallHead = head;
        		smallTail = head;
        	}
        	previousNum = head.val;
        	
        	for(ListNode i = head.next;i != null;i = i.next)
        	{
        		//System.out.printf("\n i="+i.val);
        		//System.out.printf(" pre="+previousNum);       		
        		if(i.val <x && previousNum >= x)
        		{
        			if(smallHead == null)
        			{
            			smallHead = i;
            			smallTail = i;
        			}
        			else 
        			{
        				smallTail.next = i;
        				smallTail = smallTail.next;
        			}
        		}
        		else if(i.val >= x && previousNum >= x)
        			bigTail = i;       			
        		else if(i.val >= x && previousNum < x)
        		{
        			if(bigHead == null)
        			{
            			bigHead = i;
            			bigTail = i;
        			}
        			else {       						
        				bigTail.next = i;
        				bigTail = bigTail.next ;
        			}
        		}
        		else
        			smallTail = i;
        			      		
        		previousNum = i.val;
        		
        	//	if(smallTail != null)System.out.printf(" sT="+smallTail.val);
        	//	if(bigTail != null)System.out.printf(" bT="+bigTail.val);
        	}
        
        }
        else return head;
        
        if(smallHead != null && bigHead != null)
        {
        	bigTail.next = null;
        	smallTail.next = bigHead;
        	return smallHead;
        }
        else if(smallHead != null) return smallHead;
        else if(bigHead != null) return bigHead;
        else return head;
    }
}
