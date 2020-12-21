package flowcontrolstatement;

public class SwitchDemo {

	public static void main(String[] args) {
		
		int x=2;
		
		switch(x)
		{
		case 1:
			System.out.println("Case1 Executed");
			break;
		case 2:
			System.out.println("Case2 Executed");
			break;
		case 3:
			System.out.println("Case3 Executed");
			break;
		default:
			System.out.println("No Proper Case Matched");
		}

	}

}
