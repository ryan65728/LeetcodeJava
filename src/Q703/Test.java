package Q703;

import java.util.Random;
public class Test {

	public static void main(String[] arg) {
		// TODO Auto-generated method stub
		int[] testCase = new int [99];// = {2,1,4,8,9,12,4,7,9};
		Random rand = new Random();
		for(int i = 0;i < testCase.length;i++)
		{
			testCase[i] = rand.nextInt(2000); 
		}
		KthLargest a = new KthLargest(99,testCase);
		KthLargest1 a1 = new KthLargest1(99,testCase);
	//	a.print();
		int j = 0;
		for(int i = 0;i < 30;i++)
		{
			int temp = rand.nextInt(6000);
			if(a.add(temp) != a1.add(temp))
			{
				System.out.println("Wrong in "+temp+" j="+j);
				j++;
			}
		}
		System.out.println("ans = "+a.add(189));
		System.out.println("ans1 = "+a1.add(189));
		//a.print();
		//System.out.println("ans = "+a.add(rand.nextInt(9999)));
		//a.print();
		//System.out.println("ans = "+a.add(rand.nextInt(9999)));
		//a.print();
		//System.out.println("ans = "+a.add(rand.nextInt(9999)));
		//a.print();
	}

}
