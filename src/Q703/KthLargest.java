package Q703;


public class KthLargest {
	int[] heap = null;
	int size = 0;
    public KthLargest(int k, int[] nums) {
    	heap = new int[k];
    	for(int i = 0;i < nums.length;i++)
    		add(nums[i]);
    	
    }
    
    public int add(int val) {
    	if(size < heap.length) {
    		if(size == 0)    		
    			heap[0] = val;    			    	
    		else
    		{
    			int it = size;
    			int parent = 0;
    			while(it > 0)
    			{
    				parent = it/2;
    				if(heap[parent] > val)
    				{
    					heap[it] = heap[parent];
    					it = parent;
    				}
    				else
    					break;
    			}
    			heap[it] = val;
    		}
    		size++;
    	}
    	else
    	{
    		if(val > heap[0])
    		{
    			int it =0;  
    			while((it*2+1) < size)
    			{
    				int min = it*2+1,max = it*2+2;;
    				if(max < size && heap[min] > heap[max])
    					min = max;
    				
    				if(heap[min] < val)
    				{
    					heap[it] = heap[min];
    					it = min;
    				}
    				else
    					break;
    			}
    			heap[it] = val;
    		}
    	}
    	return heap[0];
    }
    
    public void print()
    {
    	for(int i = 0;i < size;i++)
    	{
    		System.out.printf(" "+heap[i]);
    	}
    	System.out.printf(" \n");
    }
}

