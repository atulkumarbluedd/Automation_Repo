package practiceProjectcoding;

public class classB extends classA {

	int j = 0;

//	final int m() {
//		System.out.println("hi this is m");
//		return 7;
//	}

	
	classB()
	{
		super();
		System.out.println("constructor of B");
	}
	public void method(int a, int b) {

		super.m();
		System.out.println(" hello class B");
	}

	public void methodclass(classA a) {
		System.out.println("********************");
	}
	
	@Override
	public void method(int a) {
		 
		 
	}
}
