package Q703;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest1 {
    private Queue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        for (int i: nums) {
            addToQ(i);
        }
    }
    
    public int add(int val) {
        addToQ(val);
        return pq.peek();
    }
    
    private void addToQ(int i) {         
            if (pq.size() >= k)
            {
                if(i > pq.peek()) 
                {
                	
                	pq.offer(i);
                	pq.poll();
                }
            }
            else
            {
            	pq.offer(i);
            }
    }
}
