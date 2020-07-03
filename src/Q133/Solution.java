package Q133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
	public Node cloneGraph(Node node) {
		Set<Integer> done = new HashSet<Integer>();
		Stack<Node> working = new Stack<Node>();
		Map<Integer,Node> list = new HashMap<Integer,Node>();
		Node head = null;
		if(node != null) 
		{
			working.push(node);
			head = new Node(node.val);
			list.put(node.val, head);
			done.add(node.val);
		}
		while(!working.isEmpty())
		{
			Node temp = working.pop();
			Node tempClone = list.get(temp.val);
			
		//	System.out.println("node "+temp.val+"----------------");
			for(Node jt:temp.neighbors)
			{
				if(!done.contains(jt.val)) 
				{
					working.push(jt);
					done.add(jt.val);
				}
				if(list.get(jt.val) == null) 
				{
					Node nodeCopy = new Node(jt.val);					
					tempClone.neighbors.add(nodeCopy);
					list.put(nodeCopy.val, nodeCopy);
					//System.out.println("new "+nodeCopy.val);
				}
				else
				{
					tempClone.neighbors.add(list.get(jt.val));
					//System.out.println(" "+jt.val);
				}					
			}
		}
		return head;
	}
}


class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

