package Q275;


class Solution {

     public int hIndex(int[] citations) {
    	 int length = citations.length;
    	 if(length == 0)
    		 return 0;
         int l = 0,r = length -1;
         int mid = 0;
         if(citations[l] >= length)
        	 return length;
         if(citations[r] < 1)
        	 return 0;
         while(l+1 < r)
         {
        	 mid = (r+l)/2;
        	 if(citations[mid] >= (length - mid))
        		 r = mid;
        	 else
        		 l = mid;
         }
         return (length - r);
     }
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[] testCase = {0,1,1,1,1,1,1,2,2,2,2,2,2,3};
		int   result = a.hIndex(testCase);
		//for(Integer i:result)
		{
			System.out.print(" "+result);
		}
		
	 }
}