package Q211;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class WordDictionary {
	public Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
    	root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	addWord(word,root);
    }
    
    public void addWord(String word,Trie tri) {
    	if(!word.isEmpty())
    	{
    		String tmp = word.substring(0, 1);
    		Trie suTri = tri.next.get(tmp);
    		   		
    		if(suTri == null) 
    		{
    			suTri = new Trie(tmp);
    			tri.next.put(tmp, suTri);
    		}
    		else   
    		{ 		
    			suTri.countAdd();
    		}
    		if(word.length() == 1)
    			suTri.termAdd();

    		addWord(word.substring(1),suTri);
    	}
    }
  
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
		if(word.length() == 0)
			return true;
		Stack<Trie> triStack = new Stack<Trie>();
		Stack<String> strStack = new Stack<String>();
		triStack.add(root);
		strStack.add(word);
		while(!triStack.isEmpty())
		{
			Trie tri = triStack.pop();
			String str = strStack.pop();
			String tmp = (str.length() > 0 ?str.substring(0, 1):"");
	
			for(;str.length() > 0;str = str.substring(1),tmp = (str.length() > 0 ?str.substring(0, 1):"")) 
			{
				if(tmp.equals(".")) 
				{
					if(tri.next.isEmpty())
						break;// ... but dictionary only 'a'
					for (Map.Entry<String, Trie> it : tri.next.entrySet())
					{
						if(str.length() == 1 && it.getValue().isTermin())
							return true;
						triStack.add(it.getValue());
						strStack.add(str.substring(1));
					}
					break;
				}	
				else if(tmp.matches("^[a-z]")){
					tri = tri.next.get(tmp);
					if(tri == null)
						break;
					else if(str.length() == 1 && tri != null && tri.isTermin())
						return true;
				}
				else
				{
					System.out.println("ans = "+"a".substring(1));
				}
			}
						
		}
		return false;
    }
}

class Trie
{
	String c;
	Map<String,Trie> next;
	int count;
	boolean terminate;
	Trie()// only root can use this constructor 
	{
		c = "";
		next = new HashMap<String,Trie>();
		count = 1;
		terminate = true;
	}
	
	Trie(String c)
	{
		this.c = c;
		next = new HashMap<String,Trie>();
		count = 1;
		terminate = false;
	}
	
	void countAdd()
	{
		count++;
	}
	
	void termAdd()
	{
		terminate = true;
	}
	
	boolean isTermin()
	{
		return terminate;
	}
}