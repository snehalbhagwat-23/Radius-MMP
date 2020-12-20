package nonPrimitvedataType;

public class Cars {

	public static void main(String[] args) 
	{
		//syntax: datatype variable[]=new datatype[size];
		String cars[]=new String[5];
		cars[0]="BMW";
		cars[1]="Audi";
		cars[2]="Benz";
		cars[3]="Ford";
		cars[4]="GMC";
		
		System.out.println(cars[2]);
		
		System.out.println("*****************");
		
		for (String carrmake : cars) 
		{
			System.out.println(carrmake);
		}
	}

}
