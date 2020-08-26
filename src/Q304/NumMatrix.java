package Q304;


 
class NumMatrix {
		int [][] temp;
		int [][] sum;
		int r_len;
		int c_len;
		boolean zero;
    	public NumMatrix(int[][] matrix) {
    		temp = matrix;    		
    		r_len = temp.length;
    		zero = false;
    		if(r_len == 0)
    		{
    			zero = true;
    			return;
    		}
    		c_len = temp[r_len-1].length;
    		if(c_len == 0)
    		{
    			zero = true;
    			return;
    		}
    		sum = new int[r_len][c_len];
    		for(int i = 0;i < r_len;i++)
    		{
    			sum[i][0] = temp[i][0];
    			for(int j =1;j < c_len;j++)
    			{
    				sum[i][j] = sum[i][j-1]+temp[i][j];
    			}
    		}
    	}
    
    	public int sumRegion(int row1, int col1, int row2, int col2) { 
    		int result = 0;
    		if(zero)
    			return result;
    		for(int i = row1;i <= row2;i++)
    		{
    			result+=(col1 > 0?sum[i][col2] - sum[i][col1-1]:sum[i][col2]);
    		}
    		return result;
    	}
    
 	 public static void main(String[] args) {
		// TODO Auto-generated method stub
 		int[][] testCase = {{}};
		NumMatrix a = new NumMatrix(testCase);
		
		int  result = a.sumRegion(0,0,0,0);
		//for(Integer i:result)
		{
			System.out.print(" "+result);
		}
		
	 }
}