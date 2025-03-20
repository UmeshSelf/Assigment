package logicalProgramming;

public class PrintOnetoHundred {
	/*
	Print output as 1 to 100 |
	without using numbers */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int one = 'A'/'A' ;//1
		String s1 = "..........";
		
		for (int i=one; i<=(s1.length()*s1.length()); i++)
		{
			System.out.println(i);
		}

	
	
	//Using ASCII value
	//a 97 b 98 .....
	for (int i = one ; i<='d'; i+=one)
	{
		System.out.println(i);
	}

		}
}
