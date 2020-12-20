package flowcontrolstatement;

import java.util.Scanner;

public class EvenorOdd2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Number :");
		int num = scan.nextInt();
		
		if(num%2==0)
		{
			System.out.println("Given Number is Even");
		}
		else
		{
			System.out.println("Given Number is Odd");
		}
		
		scan.close();

	}

}
