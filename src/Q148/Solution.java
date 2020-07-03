package Q148;

class Solution {
	ListNode head = null;
    public ListNode sortList(ListNode head) {
    	this.head = head;
    	QuickSortList(null,head,null);
    	return this.head;
    }
    
    public void QuickSortList(ListNode preTarget,ListNode target,ListNode end) {
    	if(target == null || target == end)
    		return;
    	ListNode start = null,preStart = null,preT = preTarget,preIt = target;
    	//System.out.println("------------Deal:"+target.val);
    	for(ListNode it = target.next;it != end;it = it.next)
    	{
    		
    		if(it.val < target.val) 
    		{
    			//System.out.println("Insert "+it.val+" before "+target.val);
    			if(preT == null) 
    				head = preT = LinkedlistInsertSwap(preT,target,preIt,it);
    			else
    				preT = LinkedlistInsertSwap(preT,target,preIt,it);   
    			
    			if(start == null) 
    			{
    				if(preTarget != null)
    					preStart = preTarget;
    				start = preT;
    				//System.out.println("Start:"+start.val+" and prestart:"+(preStart == null?null:preStart.val));
    			}
    			
    		}
    		preIt = it;
    	}
    	QuickSortList(preStart,start,target);
    	QuickSortList(target,target.next,end);
    	
    }
        
    public ListNode LinkedlistInsertSwap(ListNode pre1, ListNode temp1,ListNode pre2, ListNode temp2)//insert temp2 into front temp1
    {
    	if(temp1 == temp2) return temp1;
      		
        if(temp1 != null && temp2 != null)
        {
        	//System.out.printf(" tmp1:"+temp1.val+" tmp2:"+temp2.val);//+" pre1:"+pre1.val);//+" pre2:"+pre2.val); 
        	ListNode temp = temp2.next;
        	temp2.next = temp1;
        	pre2.next = temp;             	          	
     	    if(pre1 != null) 
        		pre1.next = temp2;
        }       	       	
        return temp2;     
    }
}

class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 