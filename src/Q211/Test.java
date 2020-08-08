package Q211;

import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary a = new WordDictionary();
		a.addWord("apple");
		a.addWord("apply");
		a.addWord("app");
		a.addWord("bpq");
		a.addWord("bpapend");
		a.addWord("cpp");
		for (Map.Entry<String, Trie> it : a.root.next.entrySet())
		{			
			System.out.printf("key = "+it.getKey());
		}
		System.out.println("ans = "+"a".substring(1));
		System.out.println("ans = "+a.search("appe"));
		System.out.println("ans = "+a.search(".p.l."));
		System.out.println("ans = "+a.search("."));
		System.out.println("ans = "+a.search(""));
		System.out.println("ans = "+a.search("..apend"));
		System.out.println("ans = "+a.search("....."));
		System.out.println("ans = "+a.search("bpp"));
	}

}
