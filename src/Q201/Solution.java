package Q201;

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	int bigest_XORbit = -1;
        int xor_result = m^n;
        for(int i =0;i < 32;i++)
        {
        	if(((xor_result >> i)&0x1) == 0x1)
        		bigest_XORbit = i;
        }
        
        if(bigest_XORbit == -1)
        	return m;
        else
        	return n&(0xFFFFFFFF<<bigest_XORbit+1);
    }
}