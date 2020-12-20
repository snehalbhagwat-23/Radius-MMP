package nonPrimitvedataType;

public class ArrayExample1 {

	public static void main(String[] args) {
		
		//syntax: datatype variable[]=new datatype[size];
		
		int i[]=new int[8];
		i[0]=22; //Lowerbound
		i[1]=31;
		i[2]=45;
		i[3]=67;
		i[4]=88;
		i[5]=11;
		i[6]=98;
		i[7]=37; // Upperbound
		
		//System.out.println(i[8]); this will give an exception arrayindexoutofbound
		
		// how to check the size
		int sizeofArray = i.length;
		System.out.println("array size "+ sizeofArray);
		
		System.out.println("*****************************");
		
		//index
		System.out.println(i[6]);
		System.out.println(i[5]);
		System.out.println(i[0]);
		
//		System.out.println("*****************************");
		
		// how to print all the values of array
	/*	for(int j=0;j<sizeofArray;j++)
		{
			System.out.println(i[j]);
		}*/
		
		System.out.println("*****************************");
		// advance forloop also known as foreach loop
		for (int j : i) 
		{
			System.out.println(j);
		}

	}

}
