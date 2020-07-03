package Q133;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int[][] testCase = {{2,4},{1,3,5},{2,4,5},{1,3},{2,3}};
		Node head = new Node(1);
		Map<Integer,Node> list = new HashMap<Integer,Node>();
		list.put(1, head);
		for(int i = 0;i < testCase.length;i++)
		{
			Node temp = list.get(i+1);
			System.out.println("search node "+temp.val+" address:"+temp);
			for(int j:testCase[i])
			{		
				//System.out.println("i:"+i+" j:"+j);
				if(list.get(j)==null)
				{
					Node copy = new Node(j);
					list.put(j, copy);
					temp.neighbors.add(copy);
					System.out.println("new "+j+" address:"+copy);
				}
				else 
				{
					temp.neighbors.add(list.get(j));
					System.out.println("odd "+j);
				}
			}
		}

		Node temp =a.cloneGraph(head);
		list.clear();
		list.put(temp.val,temp);
		for(int i = 0;i < testCase.length;i++)
		{
			Node mytemp = list.get(i+1);
			if(mytemp != null)
			{
				System.out.println("search node "+mytemp.val+" address:"+mytemp);
				for(Node j:mytemp.neighbors)
				{
					System.out.println(" "+j.val);
					if(list.get(j.val) == null)
						list.put(j.val,j);
				}
			}
		}
	}

}
