package Q125;

class Solution {
    public boolean isPalindrome(String s) {
    	String temp ="";
    	int l = 0,r = 0;
        for(int i = 0;i < s.length();i++)
        {
        	char s_char = s.charAt(i);
        	if((s_char >= 0x61 && s_char <= 0x7A) || (s_char >= 0x30 && s_char <= 0x39))
        		temp += s_char;        	
        	else if(s_char >= 0x41 && s_char <= 0x5A)
        	{
        		s_char += 0x20;
        		temp += s_char;
        	}
        }
        System.out.println("temp = "+temp);
        r = temp.length()-1;
        
        while(l < r)
        {
        	if(temp.charAt(l++) != temp.charAt(r--))
        		return false;
        }
        return true;
    }
}