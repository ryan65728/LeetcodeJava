package Q227;



import java.util.Iterator;
import java.util.Stack;


class Solution {
	Stack<Integer> aInt;
	Stack<String> symbol;
	Stack<Integer> num;
    public int calculate(String s) {
        symbol = new Stack<String>();
        num = new Stack<Integer>();
        aInt = new Stack<Integer>();
        boolean quickDeal = false;
        for(int i = 0;i < s.length();i++)
        {
        	switch(s.charAt(i))
        	{
        		case '0':
        		case '1':
        		case '2':
        		case '3':
        		case '4':
        		case '5':
        		case '6':
        		case '7':
        		case '8':
        		case '9':
        			aInt.push(s.charAt(i)-'0');
        			break;
        		case '+':
        		case '-':
        			deal(quickDeal);
        			quickDeal = false;
        			symbol.push(s.substring(i, i+1));
        			break;
        		case '*':
        		case '/':
        			deal(quickDeal);
        			symbol.push(s.substring(i, i+1));
        			quickDeal = true;
        			break;
        		default:
        			break;
        	}
        }
        deal(quickDeal);
		int sum = 0,j=1;
		if(!num.isEmpty())
			sum = num.get(0);
		Iterator<String> sym = symbol.iterator();
        while(sym.hasNext())
        {
        	sum=cal(sum,num.get(j),sym.next());
			j++;
        }
        return sum;
    }

    void deal(boolean quickDeal)
    {
		if(!aInt.isEmpty())
			num.push(CreateNum());
		if(quickDeal)
		{
			int a = num.pop();	
			num.push(cal(num.pop(),a,symbol.pop()));
		}
    }
    
    int CreateNum()
    {
    	int sum = 0;  
    	int size = aInt.size();
    	for(int i = 0;i < size;i++)
    	{
    		sum += aInt.pop()*Math.pow(10, i);   		
    	}
    	return sum;
    }
    
    int cal(Integer a,Integer b,String sym)
    {
    	switch(sym.charAt(0))
    	{
			case '+':
				return a+b;
			case '-':
				return a-b;
    		case '*':
    			return a*b;
    		case '/':
    			return b>0?a/b:0;
    	}
    	return 0;
    }
   
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		String testCase = "3 -5*32767* 32767 -728/32 / 3";
		System.out.printf("ans = "+a.calculate(testCase));
	}
}