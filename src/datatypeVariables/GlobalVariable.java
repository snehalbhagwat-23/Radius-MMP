package datatypeVariables;

public class GlobalVariable {
	
	String name;
	int rollno;
	char grade;
	//
	//
	//
	//
	//
	
	public static void main(String[] args) 
	{
		GlobalVariable gv = new GlobalVariable();
		gv.name="shantosh";
		gv.rollno=4575;
		gv.grade='c';
		System.out.println(gv.name);
		System.out.println(gv.rollno);
		System.out.println(gv.grade);
		
		GlobalVariable student = new GlobalVariable();
		student.name="rajesh";
		student.grade='f';
		student.rollno=889;
		System.out.println(student.name);
		System.out.println(student.grade);
		System.out.println(student.rollno);
		
		
	}

}
