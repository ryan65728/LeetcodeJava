package Q165;

class Solution {
    public int compareVersion(String version1, String version2) {
    	int i = 0,j = 0;
    	boolean v1_dot_finish = false,v2_dot_finish = false;
    	boolean v1_first_nonzero = false,v2_first_nonzero = false;
    	int v1biggerv2_first = 0;
    	while(i < version1.length() || j < version2.length())
    	{
    		char v1 = '0';
    		char v2 = '0';
    				
    		if(i < version1.length()) 
    		{
    			v1 = version1.charAt(i);
        		if(v1 == '.') 
        			v1_dot_finish = true;       		
    		}
    		else
    			v1_dot_finish = true;
    		    		
    		if(j < version2.length()) 
    		{
    			v2 = version2.charAt(j);
        		if(v2 == '.')
        			v2_dot_finish = true;
    		}
    		else
    			v2_dot_finish = true;

    		if((v1_dot_finish && v2_dot_finish) || (v1_dot_finish && v2_first_nonzero) ||(v2_dot_finish && v1_first_nonzero))
    		{
    		//	System.out.println("-----------state-------------");
    		//	System.out.println("v1biggerv2_first:"+v1biggerv2_first+" v1_first_nonzero:"+(v1_first_nonzero?"ture":"false")+
    		//			" v2_first_nonzero:"+(v2_first_nonzero?"ture":"false"));
    			if(v1_dot_finish && !v2_dot_finish) 
    				return -1;
    			if(!v1_dot_finish && v2_dot_finish) 
    				return 1;
    				
    			if(v1biggerv2_first != 0)
    				return v1biggerv2_first;
    			else if(!v1_first_nonzero && v2_first_nonzero)
    				return -1;
    			else if(v1_first_nonzero && !v2_first_nonzero)
    				return 1;
    			
    			v1_dot_finish = false;
    			v2_dot_finish = false;
    			v1_first_nonzero = false;
    			v2_first_nonzero = false;
    			v1biggerv2_first = 0;
    			i++;
    			j++;
    		}
    		else
    		{
    			if(!v1_first_nonzero && v1 == '0' && !v1_dot_finish)
    				i++;
    			else if(v1 != '0' && !v1_dot_finish)
    				v1_first_nonzero = true;
    				
    			if(!v2_first_nonzero && v2 == '0' && !v2_dot_finish)
    				j++;
    			else if(v2 != '0' && !v2_dot_finish)
    				v2_first_nonzero = true;
    			
    			if(v1_first_nonzero && v2_first_nonzero)
    			{
    		//		System.out.println("first nonzero = "+v1+":"+v2);    				
    				if(v1biggerv2_first == 0)
    				{
    					if(v1 > v2)
    						v1biggerv2_first = 1;
    					else if(v1 < v2)
    						v1biggerv2_first = -1;
    				}
    				else
    					return v1biggerv2_first;
    				
    				i++;
    				j++;
    			}
    			
    		}
    	}
    	return v1biggerv2_first;
    }
}
