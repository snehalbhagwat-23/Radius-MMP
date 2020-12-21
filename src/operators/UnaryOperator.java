package operators;

public class UnaryOperator {

	public static void main(String[] args) {
		
	/*	int x=10;
		System.out.println(x);
		x++;
		System.out.println(x);*/
		
		int x=10;
		//int y=++x; //preincrement
		int y=x++;
		System.out.println("value of y "+y);
		System.out.println("value of x "+x);
		
		//Note: a=10++ this is not allowed. the increment or decrement should be on variable not values
		
		System.out.println("********************");
		
		int a=5;
		System.out.println(a);
		int b = a--;
		System.out.println(a);
		System.out.println(b);
		

	}

}
