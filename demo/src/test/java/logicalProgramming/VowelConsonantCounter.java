package logicalProgramming;

public class VowelConsonantCounter { public static void main(String[] args) {
		String str = "Automation World"; 
		
		str = str.toLowerCase();
		int vowels = 0, consonants = 0;
		for (int i = 0; i < str.length(); i++) { 
			char ch = str.charAt(i);
		if (ch >= 'a' && ch <= 'z') {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') { 
				vowels++;
		} 
			else {
		consonants++; 
		}
		} 
	//	System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);

		}
		System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
		} 
}