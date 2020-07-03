package Q74;

import java.util.stream.IntStream;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int upper = matrix.length-1,lower = 0;
    	if(matrix.length < 1)
    		return false;
    	while(upper != lower)
    	{
    		System.out.println("up = "+upper+" low = "+lower);
    		if(upper == lower+1)
    		{
    			if(target >= matrix[upper][0])
    				lower = upper;
    			break;
    		}	
    		if(matrix[(upper+lower)/2][0] > target)
    			upper = (upper+lower)/2;
    		else 
    			lower = (upper+lower)/2;

    	}
    	return IntStream.of(matrix[lower]).anyMatch(n -> n == target);
    }
}