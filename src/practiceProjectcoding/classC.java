package practiceProjectcoding;

public class classC {

	final int m() {
		return 5;
	}

	public static void main(String[] args) {

//	classA  a= new classB();
		classB b = new classB();
		classA abc = new classB();

		System.out.println(b.firstValue);

		b.m();
		int u = b.firstValue; // final methods and datamembers can be inherited but cant be overridden
		// when we have one method in super class then with the help of inheritance we
		// can overload this method in the subclass also.
		// So in the subclass we will have two methods one from the super class and one
		// from the subclass. And with the help of parameters we can call
		// method as per our need but we need to access using the subclass refrences.
		b.method(5);
		b.method(3, 4);

		// if method parameter is of super class then we can pass any of its sub class
		// argument.
		b.methodclass(abc);

		// with the help of child class reference we can access super class
		// data members.
		int t = b.firstValue;
		System.out.println(t);

		StringBuilder str = new StringBuilder();
		str.ensureCapacity(33);
		// default capacity of string builder is 16
		StringBuilder str2 = new StringBuilder(756454);
		System.out.println(str.capacity() + "  --");
		System.out.println(str.length());

		// downcasting
		Object b3 = 9;
		int v = (int) b3;

		;
		System.out.println(new classC().m());
	}

}
