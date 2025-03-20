package logicalProgramming;

import java.util.stream.IntStream;

public class PrintOnetoHundredwithouLoops {
	/*
	Print output as 1 to 100 |
	without using loops
	
	 * 2 ways we can do it
	 ** 1. Recursive way
	 ** 2. Java Streams
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printNum(1);
		printNumber(1,100);
		
		// Using Java streams
		IntStream.range(1, 101).forEach(e -> System.out.println(e));
		}
	
	//Using recursive way
	public static void printNum (int num) {
		if (num<=100)
		{
			System.out.println(num);
			num++;
			printNum(num);
			
		}
	}
	
	// Let say , If we dont want to hardcode value as 100 in if condition
	
	public static void printNumber (int stNum, int endNum) {
		if (stNum<=endNum)
		{
			System.out.println(stNum);
			stNum++;
			printNumber(stNum,endNum);
			
		}
	}
}
