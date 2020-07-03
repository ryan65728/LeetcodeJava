package Q92;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode temp = head;
    	for(int i = 0; i < (n-m+1)/2;i++)
    	{ 		
    		temp = LinkedlistSwap(temp,m+i,n-i);
    	}
    	return temp;
    }
    
    public ListNode LinkedlistSwap(ListNode head, int m, int n)
    {
    	ListNode it = null,pre1 = null,temp1 = null,pre2=null,temp2=null;
    	if(m == n) return head;
    	int i = 1;
        for(it = head;it != null;it = it.next)
        {

        		if(it.next != null && i+1 == m )
        			pre1 = it;
        		if(it.next != null && i+1 == n )
        			pre2 = it;
        		
        		if(i == m)
        			temp1 = it;
        		if(i == n)
        			temp2 = it;
        		
        		if(temp1 != null && temp2 != null)
        		{
        			//System.out.printf(" tmp1:"+temp1.val+" tmp2:"+temp2.val);//+" pre1:"+pre1.val);//+" pre2:"+pre2.val);
        			if(pre1 != null)
        				pre1.next = temp2;
        			
        			if(pre2 != null)
        				pre2.next = temp1;
        			
        			ListNode temp = temp2.next;
        			temp2.next = temp1.next;
        			temp1.next = temp;
        			if(m == 1) 
        				return temp2;

        			break;
        		}
       	       	
        		i++;
        }
        return head;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}