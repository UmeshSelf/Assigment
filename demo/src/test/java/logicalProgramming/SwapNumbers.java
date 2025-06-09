package logicalProgramming;

public class SwapNumbers {
public static void main(String[] args) {
int a = 10; int b = 20;
System.out.println("Before: a=" + a + ", b=" + b);
// Method 1: Using arithmetic operations a = a + b;
b = a - b;
a = a - b;
// Method 2: Using XOR (alternative) // a = a ^ b;
// b = a ^ b;
// a = a ^ b;
System.out.println("After: a=" + a + ", b=" + b); }
}